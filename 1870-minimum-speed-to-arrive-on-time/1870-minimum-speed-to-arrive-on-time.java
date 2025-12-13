class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int n = dist.length;
        int high = 10000000;

        int ans = -1;
        while(low <=high){
            int mid = (low + high) / 2;
            double sum = 0;
            for(int i = 0; i < n- 1; i++){
                sum += Math.ceil(((double) dist[i]) / mid);
            }
            sum = sum + (((double) dist[n-1]) / mid);
            if(sum > hour){
                low = mid+1;
            }else{
                ans = mid;
                high = mid-1;
            }            
        }
        return ans;
    }
}
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long mk = (long)m * k;
        if(mk > bloomDay.length) return -1;

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < bloomDay.length; i++){
            mini = Math.min(mini,bloomDay[i]);
            maxi = Math.max(maxi,bloomDay[i]);
        }
        int low = mini;
        int high = maxi;

        while(low <= high){
            int mid = (low + high)/2;
            if(possible(bloomDay,mid,m,k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }


    private boolean possible(int[] arr, int day, int m, int k){
        int count = 0;
        int noOfB = 0;

        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] <= day){
                count++;
            }else{
                noOfB += count / k;
                count = 0;
            }
        }
        noOfB += count / k;
        return noOfB >= m;
    }
}
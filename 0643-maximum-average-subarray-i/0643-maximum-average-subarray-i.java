class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        double maxAvg = Double.NEGATIVE_INFINITY;
        int sum = 0;
        while(j < n){
            if(j-i+1 < k){
                sum += nums[j];
                j++;
            }else if(j-i+1==k){
                sum += nums[j];
                double avg = (double)sum/k;
                maxAvg = Math.max(avg, maxAvg);
                sum -= nums[i];
                i++;
                j++;
            }
        }
        return maxAvg;
    }
}
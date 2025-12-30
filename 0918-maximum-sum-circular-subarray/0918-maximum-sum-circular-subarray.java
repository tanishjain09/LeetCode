class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        int maxSum = kadaneMax(nums);
        int minSum = kadaneMin(nums);
        int circularSum = sum - minSum;
        if(maxSum > 0) return Math.max(maxSum, circularSum);
        return maxSum;
    }
    private int kadaneMax(int[] nums){
        int sum = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
    private int kadaneMin(int[] nums){
        int sum = nums[0];
        int minSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum = Math.min(sum + nums[i], nums[i]);
            minSum = Math.min(sum, minSum);
        }
        return minSum;
    }
    
}
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 == 1) return false;
        else return solve(nums, sum / 2);
    }
    private boolean solve(int[] nums, int k){
        int n = nums.length;
        boolean[][] dp = new boolean[n][k+1];

        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        if(nums[0] <= k){
            dp[0][nums[0]] = true;
        }

        for(int ind = 1; ind < n; ind++){
            for(int target = 1; target <= k; target++){
                boolean notTaken = dp[ind-1][target];
                boolean taken = false;
                if(nums[ind] <= target){
                    taken = dp[ind-1][target-nums[ind]];
                }
                dp[ind][target] = notTaken || taken;
            } 
        }
        return dp[n-1][k];
    }
}
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, -1, nums, dp);
    }

    private int solve(int ind, int prev_ind, int[] nums, int[][] dp){
        if(ind == nums.length) return 0;

        if(dp[ind][prev_ind+1] != -1) return dp[ind][prev_ind+1];

        int notTake = solve(ind + 1, prev_ind, nums, dp);
        int take = 0;
        if(prev_ind == -1 || nums[ind] > nums[prev_ind]){
            take = 1 + solve(ind + 1, ind, nums, dp);
        }
        return dp[ind][prev_ind+1] = Math.max(take, notTake);
    }
}
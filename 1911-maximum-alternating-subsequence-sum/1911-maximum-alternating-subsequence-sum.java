class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][2];
        for(long[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, true, nums, dp);
    }
    private long solve(int ind, boolean isEven, int[] nums, long[][] dp){
        if(ind >= nums.length) return 0;

        int even = isEven ? 1 : 0;

        if(dp[ind][even] != -1) return dp[ind][even];

        long notTake = solve(ind+1, isEven, nums, dp);
        long val = nums[ind];
        if(!isEven) val = -val;
        long take = val + solve(ind+1, !isEven, nums, dp);
        return dp[ind][even] = Math.max(notTake, take);

    }
}
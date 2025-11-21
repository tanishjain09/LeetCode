class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        if(n == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            int rob = nums[i] + dp[i-2];
            int notRob = 0 + dp[i-1];
            dp[i] = Math.max(rob, notRob);
        }
        return dp[n-1];
    }

}
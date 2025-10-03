class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxi = 1;
        Arrays.fill(dp, 1);
        for(int ind = 0; ind < n; ind++){
            for(int prev_ind = 0; prev_ind < ind; prev_ind++){
                if(nums[ind] > nums[prev_ind] && dp[prev_ind] + 1 > dp[ind]){
                    dp[ind] = dp[prev_ind] + 1;
                }
            }
            maxi = Math.max(dp[ind], maxi);
        }
        return maxi;
    }
}
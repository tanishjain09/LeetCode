class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num : nums) max = Math.max(max, num);
        int[] arr = new int[max+1];
        for(int num : nums) arr[num]++;
        int[] dp = new int[max+1];
        Arrays.fill(dp, -1);
        return solve(max, arr, dp);
        
    }
    private int solve(int ind, int[] nums, int[] dp){
        if(ind < 0) return 0;
        if(nums[ind] == 0) return solve(ind-1, nums, dp);
        if(dp[ind] != -1) return dp[ind];
        int pick = 0, notPick = 0;
        pick = nums[ind] * ind + solve(ind-2, nums, dp);
        notPick = solve(ind-1, nums, dp);
        return dp[ind] = Math.max(pick, notPick);
    }
}
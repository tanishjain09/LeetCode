class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][3];

        for(int[][] row : dp){
            for(int[] cell : row){
                Arrays.fill(cell, -1);
            }
        }
        return solve(0, 1, 2, prices, dp);
    }
    private int solve(int ind, int buy, int cap, int[] prices, int[][][] dp){
        if(ind == prices.length || cap == 0) return 0;
        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];

        if(buy == 1){
            return dp[ind][buy][cap] = Math.max(-prices[ind] + solve(ind+1,0,cap,prices,dp), solve(ind+1,1,cap,prices,dp));
        }
        
        return dp[ind][buy][cap] = Math.max(prices[ind] + solve(ind+1,1,cap-1,prices,dp), solve(ind+1,0,cap,prices,dp));
        

    }
}
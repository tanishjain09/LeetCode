class Solution {
    int M = 1000000007;
    String[] states = {
        "RYG", "RGY", "RYR", "RGR",
        "YRG", "YGR", "YGY", "YRY",
        "GRY", "GYR", "GRG", "GYG"
    };
    int[][] dp;
    public int numOfWays(int n) {
        dp = new int[n][12];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int res = 0;
        for(int i = 0; i < 12; i++){
            res = (res+solve(n-1, i)) % M;
        }
        return res;
    }
    private int solve(int n, int prev){
        if(n == 0) return 1;
        if(dp[n][prev] != -1) return dp[n][prev];

        int res = 0;
        String last = states[prev];
        for(int curr = 0; curr < 12; curr++){
            if(curr == prev) continue;
            String currPattern = states[curr];
            boolean conflict = false;
            for(int col = 0; col <3; col++){
                if(currPattern.charAt(col) == last.charAt(col)){
                    conflict = true;
                    break;
                }
            }
            if(!conflict){
                res = (res + solve(n-1, curr)) % M;
            }
        }
        return dp[n][prev] = res;
    }
}
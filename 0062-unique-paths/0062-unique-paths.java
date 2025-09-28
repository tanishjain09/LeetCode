class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return uniquePaths(m-1, n-1, dp);
    }

    private int uniquePaths(int m, int n, int[][] dp){
        if(m == 0 || n == 0) return 1;
        if(dp[m][n] != -1)  return dp[m][n];
        int left = uniquePaths(m-1, n, dp);
        int right = uniquePaths(m, n-1, dp);

        return dp[m][n] = left + right;
    }
}
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row: dp){
            Arrays.fill(row, - 1);
        }
        return solve(n-1, m-1, grid, dp);
    }
    private int solve(int n, int m, int[][] grid, int[][] dp){
        if(n == 0 && m == 0) return grid[n][m];
        if(n < 0 || m < 0) return (int)Math.pow(10, 9);

        if(dp[n][m] != -1) return dp[n][m];

        int up = grid[n][m] + solve(n-1, m, grid, dp);
        int left = grid[n][m] + solve(n, m-1, grid, dp);

        return dp[n][m] = Math.min(up, left);
    }
}
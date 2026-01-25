class Solution {

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for(int[][] row : dp){
            for(int[] r : row){
                Arrays.fill(r, -1);
            }
        }
        return solve(0, 0, m-1, grid, dp);
    }
    private int solve(int ind, int c1, int c2, int[][] grid, int[][][] dp){
        int m = grid[0].length;
        int n = grid.length;
        if(c1 < 0 || c1 >= m || c2 < 0 || c2 >= m) return -Integer.MAX_VALUE;
        if(ind == n-1){
            if(c1==c2) return grid[ind][c1];
            else return grid[ind][c1] + grid[ind][c2];
        }
        if(dp[ind][c1][c2] != -1) return dp[ind][c1][c2];
        int max = 0;
        for(int d1 = -1; d1 <= 1; d1++){
            for(int d2 = -1; d2 <= 1; d2++){
                int next = solve(ind+1, c1+d1, c2+d2, grid, dp);
                max = Math.max(next, max);
            }
        }
        int curr = 0;
        if(c1 == c2)
            curr = grid[ind][c1];
        else 
            curr = grid[ind][c1] + grid[ind][c2];
        return dp[ind][c1][c2] = curr + max;
    }
}
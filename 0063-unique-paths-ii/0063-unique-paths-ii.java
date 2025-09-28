class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) dp[i][j] = 0;
                else if(i == 0 && j == 0) dp[i][j]=1;
                else{
                    int up = (i > 0) ? dp[i-1][j] : 0;
                    int left = (j > 0) ? dp[i][j-1] : 0;
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[n-1][m-1];
    }
    
}
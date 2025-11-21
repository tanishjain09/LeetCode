class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length; 
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(n-1, m-1, dp, obstacleGrid);
    }
    public int solve(int i, int j, int[][] dp, int[][] arr){
        if(i < 0 || j < 0) return 0;
        if(arr[i][j] == 1) return 0;
        if(i == 0 && j == 0) {
            return 1;
        }

        if(dp[i][j] != -1) return dp[i][j];
        int right = solve(i, j-1, dp, arr);
        int down = solve(i-1, j, dp, arr);
        return dp[i][j] = right + down;
    }
}
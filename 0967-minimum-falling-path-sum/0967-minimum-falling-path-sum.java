class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for(int j = 0; j < n; j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                int top = matrix[i][j] + dp[i-1][j];
                int leftDia = matrix[i][j];
                if(j > 0) leftDia += dp[i-1][j-1];
                else leftDia += Math.pow(10,9);

                int rightDia = matrix[i][j];
                if(j < n-1)rightDia += dp[i-1][j+1];
                else rightDia += Math.pow(10,9);

                dp[i][j] = Math.min(top, Math.min(leftDia, rightDia));
            }
        }
        int mini = dp[n-1][0];

        for(int j = 1; j < n; j++){
            mini = Math.min(mini, dp[n-1][j]);
        }
        return mini;
    }
}
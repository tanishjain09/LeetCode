class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(0, 0, s1, s2, dp);
    }
    private int helper(int i, int j, String s1, String s2, int[][] dp){
        int n = s1.length();
        int m = s2.length();
        if(i == n && j == m) return 0;
        if(i==n){
            int sum = 0;
            for(int k = j; k < m; k++) sum+=s2.charAt(k);
            return sum;
        }
        if(j == m){
            int sum = 0;
            for(int k = i; k < n; k++) sum += s1.charAt(k);
            return sum;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = helper(i+1,j+1,s1,s2,dp);
        }
        int left = s1.charAt(i) + helper(i+1, j, s1, s2, dp);
        int right = s2.charAt(j) + helper(i, j+1, s1, s2, dp);
        return dp[i][j] = Math.min(left, right);
    }
}
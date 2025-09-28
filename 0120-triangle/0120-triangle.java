class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        int n = tri.size();
        int[][] dp = new int[n][n];

        for(int j = 0; j < n; j++){
            dp[n-1][j] = tri.get(n-1).get(j);
        }

        for(int i = n-2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                int down = dp[i+1][j];
                int dia = dp[i+1][j+1];

                dp[i][j] = tri.get(i).get(j) + Math.min(down, dia);
            }
        }
        return dp[0][0];
    }
}
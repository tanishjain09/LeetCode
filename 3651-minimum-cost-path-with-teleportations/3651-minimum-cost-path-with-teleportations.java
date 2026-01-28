class Solution {
    public int minCost(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int INF = Integer.MAX_VALUE;
        int[][][] dp = new int[k + 1][n][m];
        for (int[][] row : dp) {
            for (int[] r : row) {
                Arrays.fill(r, INF);
            }
        }
        dp[0][0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0) {
                    dp[0][i][j] = Math.min(dp[0][i][j], dp[0][i - 1][j] + grid[i][j]);
                }
                if (j > 0) {
                    dp[0][i][j] = Math.min(dp[0][i][j], dp[0][i][j - 1] + grid[i][j]);
                }
            }
        }
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = grid[i][j];
                if (!map.containsKey(val)) {
                    map.put(val, new ArrayList<>());
                }
                map.get(val).add(new int[] { i, j });
            }
        }
        List<Integer> values = new ArrayList<>(map.keySet());
        Collections.sort(values, Collections.reverseOrder());

        for (int t = 1; t <= k; t++) {
            int mn = INF;
            for (int val : values) {
                List<int[]> cells = map.get(val);

                for(int[] cell : cells){
                    mn = Math.min(mn, dp[t-1][cell[0]][cell[1]]);
                }
                for (int[] cell : cells) {
                    dp[t][cell[0]][cell[1]] = mn;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i > 0) {
                        dp[t][i][j] = Math.min(dp[t][i][j], dp[t][i - 1][j] + grid[i][j]);
                    }
                    if (j > 0) {
                        dp[t][i][j] = Math.min(dp[t][i][j], dp[t][i][j - 1] + grid[i][j]);
                    }
                }
            }
           
        }
         int ans = INF;
            for(int t = 0; t <= k; t++){
                ans = Math.min(ans, dp[t][n-1][m-1]);
            }
        return ans;
    }
}
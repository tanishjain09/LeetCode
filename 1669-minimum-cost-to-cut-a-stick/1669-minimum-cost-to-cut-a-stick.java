class Solution {
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int cut : cuts) {
            arr.add(cut);
        }
        arr.add(0);
        arr.add(n);
        Collections.sort(arr);
        int c = arr.size();
        int[][] dp = new int[c][c];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(1, c-2, arr, dp);
    }
    private int solve(int i, int j, ArrayList<Integer> cuts, int[][] dp){
        if(i > j) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        int mini = Integer.MAX_VALUE;

        for (int ind = i; ind <= j; ind++) {
            int ans = cuts.get(j + 1) - cuts.get(i - 1) +
                      solve(i, ind - 1, cuts, dp) +
                      solve(ind + 1, j, cuts, dp);

            mini = Math.min(mini, ans);
        }

        return dp[i][j] = mini;
    }
}
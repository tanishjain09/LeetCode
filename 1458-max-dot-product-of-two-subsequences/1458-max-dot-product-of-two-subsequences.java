class Solution {
    private static int NEG_INF = Integer.MIN_VALUE;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row, NEG_INF); //-1 will fail as product can be negative
        }

        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                int product = nums1[i] * nums2[j];
                int take = product;
                int next = dp[i+1][j+1];
                if(next != NEG_INF) take = Math.max(take, product + next);
                int skipFrom1 = dp[i+1][j];
                int skipFrom2 = dp[i][j+1];
                dp[i][j] = Math.max(take, Math.max(skipFrom1, skipFrom2));
            }
        }
        return dp[0][0];
    }
    private int solve(int[] nums1, int[] nums2, int i, int j, int[][] dp){
        int n = nums1.length;
        int m = nums2.length;
        if(i == n || j == m)return NEG_INF;
        if(dp[i][j] != NEG_INF) return dp[i][j];

        int product = nums1[i] * nums2[j];
        int take = product;
        int next = solve(nums1, nums2, i+1, j+1, dp);
        if(next != NEG_INF) take = Math.max(take, next + take);

        int skipFrom1 = solve(nums1, nums2, i+1, j, dp);
        int skipFrom2 = solve(nums1, nums2, i, j+1, dp);
        return dp[i][j] = Math.max(take, Math.max(skipFrom1, skipFrom2));
    }
}
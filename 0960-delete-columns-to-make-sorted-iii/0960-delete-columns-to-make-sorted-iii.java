class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int[][] dp = new int[m][m+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return m-solve(0, -1, strs, dp);
    }
    private int solve(int ind, int prev, String[] strs, int[][] dp){
        int n = strs.length;
        int m = strs[0].length();
        if(ind == m) return 0;

        if(dp[ind][prev+1] != -1)return dp[ind][prev+1];
        int pick = 0;
        int skip = solve(ind+1, prev, strs, dp);
        if(prev==-1){
            pick = 1 + solve(ind+1, ind, strs, dp);
        }else{
            boolean flag = true;
            for(int j = 0; j < n; j++){
                if(strs[j].charAt(ind) < strs[j].charAt(prev)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                pick = 1 + solve(ind+1, ind, strs, dp);
            }
        }
        return dp[ind][prev+1] = Math.max(pick, skip);
    }
}
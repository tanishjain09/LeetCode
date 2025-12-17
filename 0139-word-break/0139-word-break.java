class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, 0, s, new HashSet<>(wordDict), dp);
    }
    private boolean solve(int start, int end, String s, Set<String> set, int[][] dp){
        if(dp[start][end] != -1) return dp[start][end]==1 ? true : false;
        //base condition
        if(end == s.length() -1){
            if(set.contains(s.substring(start, end+1))) return true;
            return false;
        }

        if(set.contains(s.substring(start, end +1))){
            if(solve(end+1, end+1, s, set, dp)){
                dp[start][end] = 1;
                return true;
            }
        }
        boolean ans = solve(start, end+1, s, set, dp);
        dp[start][end] = ans ? 1 : 0;
        return ans;
    }
}
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int lcs = lcs(word1, word2);
        return (n - lcs) + (m - lcs);
    }
    private int lcs(String s, String t){
        int n = s.length();
        int m = t.length();

        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)) curr[j] = 1 + prev[j-1];
                else curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}
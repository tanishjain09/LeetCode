class Solution {
    public int minInsertions(String s) {
        return s.length() - longestPalindrome(s);
    }

    private int longestPalindrome(String s){
        String reverse = new StringBuilder(s).reverse().toString();

        int n = s.length();
        int m = reverse.length();

        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i-1) == reverse.charAt(j-1)) curr[j] = 1 + prev[j-1];
                else curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}
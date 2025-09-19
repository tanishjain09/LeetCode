class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxF = 0, maxL = 0;
        int[] hash = new int[26];
        int n = s.length();
        while(r < n){
            hash[s.charAt(r)-'A']++;
            maxF = Math.max(maxF, hash[s.charAt(r)-'A']);
            while((r-l+1) - maxF > k){
                hash[s.charAt(l)-'A']--;
                l=l+1;
            }
            maxL = Math.max((r-l+1), maxL);
            r++;
        }
        return maxL;
    }
}
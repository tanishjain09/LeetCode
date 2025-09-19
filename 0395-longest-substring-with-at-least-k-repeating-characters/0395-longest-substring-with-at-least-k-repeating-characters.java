class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        int n =s.length();
        for(int uniqueTarget = 1; uniqueTarget <= 26; uniqueTarget++){
            int l = 0, r = 0;
            int[] hash = new int[26];
            int unique = 0, countAtleastk  = 0;

            while(r < n){
                if(hash[s.charAt(r) - 'a'] == 0) unique++;
                hash[s.charAt(r) - 'a']++;
                if(hash[s.charAt(r) - 'a'] == k) countAtleastk++;
                r++;

                while(unique > uniqueTarget){
                    if(hash[s.charAt(l) - 'a'] == k) countAtleastk--;
                    hash[s.charAt(l) - 'a']--;
                    if(hash[s.charAt(l)-'a'] == 0) unique--;
                    l++;
                }
                if(unique == uniqueTarget && unique == countAtleastk){
                    maxLen = Math.max(maxLen, r-l);
                }
            }
        }
        return maxLen;
    }
}
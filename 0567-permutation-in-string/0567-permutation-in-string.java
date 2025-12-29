class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] hash = new int[26];
        for(char c : s1.toCharArray()){
            hash[c-'a']++;
        }
        int r = 0, l = 0;
        int cnt = 0;
        while(r < s2.length()){
            char ch = s2.charAt(r);
            hash[ch-'a']--;
            if(hash[ch-'a'] >= 0) cnt++;
            if(r-l+1 > s1.length()){
                char chL = s2.charAt(l);
                if(hash[chL-'a'] >= 0) cnt--;
                hash[chL-'a']++;
                l++;
            }
            if(cnt == s1.length()) return true;
            r++;
        }
        return false;
    }
}
class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int l = 0, r = 0, minLength = Integer.MAX_VALUE, count = 0, sIndex = -1;
        int[] hash = new int[256];
        for(int i = 0; i < m; i++){
            hash[t.charAt(i)]++;
        }
        while(r < n){
            hash[s.charAt(r)]--;
            if(hash[s.charAt(r)] >= 0) count++;
            while(count == m){
                if(r-l+1 < minLength){
                    minLength = r-l+1;
                    sIndex = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0) count--;
                l++;
            }
            r++;
        }
        return sIndex == -1? "":s.substring(sIndex, sIndex + minLength);
    }
}
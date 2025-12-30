class Solution {
    public int countGoodSubstrings(String s) {
        HashSet<Character> set = new HashSet<>();
        int count= 0;
        int l = 0, r = 0;
        while(r < s.length()){
            char ch = s.charAt(r);
            while(set.contains(ch)){
                char chL = s.charAt(l);
                l++;
                set.remove(chL);
            }
            set.add(ch);
            if(r-l+1 == 3){
                count++;
                set.remove(s.charAt(l));
                l++;
            }
            r++;
        }
        return count;
    }
}
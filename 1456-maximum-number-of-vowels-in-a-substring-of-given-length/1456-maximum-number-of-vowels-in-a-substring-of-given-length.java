class Solution {
    public int maxVowels(String s, int k) {
        int l = 0;
        int r = 0;
        int n = s.length();
        int count = 0;
        int max = 0;
        while(r < n){
            char ch = s.charAt(r);
            if(ch == 'a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;
            }
            if(r-l+1>k){
                char ch2 = s.charAt(l);
                if(ch2 == 'a'||ch2=='e'||ch2=='i'||ch2=='o'||ch2=='u'){
                count--;
                }
                l++;
            }
            r++;
            max = Math.max(count, max);
        }
        return max;
    }
}
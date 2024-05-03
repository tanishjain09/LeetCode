class Solution {
    public boolean isAnagram(String s, String t) {        
        if(s.length()!=t.length()){
            return false;
        }
        String str1 = sortString(s);
        String str2 = sortString(t);

        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public String sortString(String s){
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
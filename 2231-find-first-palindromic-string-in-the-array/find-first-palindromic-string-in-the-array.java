class Solution {
    public String firstPalindrome(String[] words) {
        int n = words.length;

       for(int i =0; i<n; i++)
       {
            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);
            sb.reverse();
            if(words[i].equals(sb.toString())){
                return sb.toString();
            }

        }
        
        return "";
    }
}
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+"," ");
        String[] str = s.split(" ");
        
        int start= 0;
        int end = str.length-1;

        while(start<end){
            String temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        String reverseString  = String.join(" ", str);
        return reverseString;
    }
}
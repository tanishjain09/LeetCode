class Solution {
    public boolean isPalindrome(String s) {
        String newString = s.replaceAll("[^a-zA-Z0-9]", "");
        newString = newString.toLowerCase();
        newString = newString.trim();
            for(int i=0; i<newString.length()/2; i++){
                if(s==null || newString.length()==0){
                return true;
                }
                char start = newString.charAt(i);
                char end = newString.charAt(newString.length()-1-i);

                if(start!=end){
                    return false;
                }
            }
            return true;
            }
        }
   

class Solution {
    public boolean isPalindrome(String s) {
        String newString = s.toLowerCase().trim().replaceAll("[^a-zA-Z0-9]", "");
            for(int i=0; i<newString.length()/2; i++){
                if(s==null || newString.length()==0){
                return true;
                }
                if(newString.charAt(i) != newString.charAt(newString.length()-1-i)){
                    return false;
                }
            }
            return true;
            }
        }
   

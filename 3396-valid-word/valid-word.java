class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        if(n < 3){
            return false;
        }

        int vowel = 0;
        int consonant = 0;

        for(char ch : word.toCharArray()){
            if(Character.isLetter(ch)){
                if("aeiouAEIOU".indexOf(ch) != -1){
                    vowel++;
                }else{
                    consonant++;
                }
            }else if(!Character.isDigit(ch)){
                return false;
            }
        }
        return vowel >= 1 && consonant>= 1;
    }
}
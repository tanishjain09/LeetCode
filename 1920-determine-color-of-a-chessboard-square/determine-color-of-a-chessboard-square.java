class Solution {
    public boolean squareIsWhite(String coordinates) {
        if(coordinates.charAt(0) == 'a' || coordinates.charAt(0) == 'c' || coordinates.charAt(0) == 'e' || coordinates.charAt(0) == 'g'){
            int next = coordinates.charAt(1);
            if(next % 2 == 0){
                return true;
            }else{
                return false;
            }
        }else{
            int next = coordinates.charAt(1);
            if(next % 2 != 0){
                return true;
            }else{
                return false;
            }
        }
    }
}
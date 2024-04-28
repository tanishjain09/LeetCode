class Solution {
    public boolean isPalindrome(int x) {
        if(xReverse(x)==x){
            return true;
        }else
        return false;

    }
    public int xReverse(int x){
        int digit;
        int NumReverse = 0;
        while(x>0){
            digit = x %10;
            NumReverse = NumReverse*10 + digit;
            x /= 10;
        }
        return NumReverse;
    }
}
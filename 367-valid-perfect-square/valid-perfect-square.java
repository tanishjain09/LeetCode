class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 0;
        int high = num;
        while(low <= high){
            int mid = (low+high) /2;
            long square =(long) mid*mid;
            if(num == square){
                return true;
            }else if(num < square){
                high = mid-1;
            }else{
                low = mid +1;
            }
        }
        return false;
    }
    
}
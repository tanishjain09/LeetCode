class Solution {
    public int countTriples(int n) {
        int a = 0;
        int b = 0;
        int count = 0;
        for(int i = 1; i <= n; i++){
            a = i;
            for(int j = 1; j <= n; j++){
                b = j;
                int sum = a*a + b*b;
                if(isSquare(sum) && Math.sqrt(sum) <= n){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isSquare(int num){
        int left = 1;
        int right = num;
        while(left <= right){
            int mid = left + (right-left) /2;
            long sq = (long)mid * mid;
            if(sq == num){
                return true;
            }else if(sq > num){
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}
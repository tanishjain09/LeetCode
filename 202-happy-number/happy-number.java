class Solution {
    public boolean isHappy(int n) {
        int f = n;
        int s = n;

        do{
            s = findSquare(s);
            f = findSquare(findSquare(f));
        }while(s!=f);

        if(s == 1){
            return true;
        }
        return false;
    }

    private int findSquare(int n){
        int ans = 0;
        while(n > 0){
            int rem = n % 10;
            ans += rem * rem;
            n /= 10;
        }
        return ans;
    }
}
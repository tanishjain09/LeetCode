class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1;
        int e = maxInPiles(piles);

        while(s <= e){
            int mid = s + (e - s) / 2;

            long sum = 0;
            for(int n : piles){
                sum += (int)Math.ceil((double)n / mid);
            }

            if(sum <= h){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return s;
    }

    private int maxInPiles(int[] piles){
        int max = Integer.MIN_VALUE;

        for(int n : piles){
            if (n > max){
                max = n;
            }
        }
        return max;
    }
}
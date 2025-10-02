class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] above = new int[2];
        int[] curr = new int[2];
        
        for(int ind = n-1; ind >= 0; ind--){
            for(int buy = 0; buy <=1; buy++){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max(-prices[ind] + above[0], above[1]);
                }else{
                    profit = Math.max(prices[ind] + above[1], above[0]);
                }
                curr[buy] = profit;
            }
            above = curr.clone();
        }
        return above[1];
    }
}
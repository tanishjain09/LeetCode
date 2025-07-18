class Solution {
    public int maxProfit(int[] arr) {
        int maxProfit = 0;
        int bestBuy = arr[0];
        for(int i = 1; i < arr.length; i++){
             if(arr[i] > bestBuy){
                maxProfit = Math.max(maxProfit, arr[i] - bestBuy);
            }
            bestBuy = Math.min(bestBuy, arr[i]);
        }   
        return maxProfit;
    }
}

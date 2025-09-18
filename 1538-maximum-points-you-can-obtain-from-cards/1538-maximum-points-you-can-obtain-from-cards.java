class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0, l = k-1, r = n-1;
        

        for(int i = 0; i<= l; i++){
            sum += cardPoints[i];
        }
        int maxSum = sum;
        while(l >= 0){
            sum -= cardPoints[l--];
            sum += cardPoints[r--];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
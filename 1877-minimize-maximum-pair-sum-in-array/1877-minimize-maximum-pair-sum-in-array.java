class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int i = 0;
        int j = n-1;
        int maxSum = 0;
        while(i < j){
            int sum = sorted[i] + sorted[j];
            maxSum = Math.max(sum, maxSum);
            i++;
            j--;
        }        
        return maxSum;
    }
}
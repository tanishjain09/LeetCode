class Solution {
    public int sumFourDivisors(int[] nums) {
        int maxSum = 0;
        for(int n : nums){
            int count = 0;
            int sum = 0;
            for(int i = 1; i <= n; i++){
                if(n % i == 0){
                    count++;
                    sum += i;
                }
                if(count > 4) break;
            }
            if(count == 4){
                maxSum += sum;
            }
        }
        return maxSum;
    }
}
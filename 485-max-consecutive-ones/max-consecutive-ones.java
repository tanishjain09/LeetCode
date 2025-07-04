class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                if(count >= maxCount){
                    maxCount++;
                }
                count++;
            }else{
                count = 0;
            }
        }
        return maxCount;
    }
}
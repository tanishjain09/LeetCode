class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int negIndex = 1,posIndex = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0){
                ans[negIndex] = nums[i];
                negIndex += 2;
            }else{
                ans[posIndex] = nums[i];
                posIndex += 2;
            }
        }
        return ans;
    }
}
class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int num : nums) sum += num;
        int maxL = -1;
        int currSum = 0;
        int l = 0, r = 0;
        while(r < nums.length){
            currSum += nums[r];
            while(l <= r & currSum > sum - x) currSum -= nums[l++];
            if(currSum == sum - x) maxL = Math.max(maxL, r-l+1);
            r++;
        }
        return maxL == -1 ? -1 : nums.length-maxL;
    }
}
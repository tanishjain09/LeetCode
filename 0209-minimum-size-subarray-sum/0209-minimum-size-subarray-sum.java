class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int l = 0;
        int r = 0;
        int minL = Integer.MAX_VALUE;
        while(r < nums.length){
            sum += nums[r];
            while(sum >= target){
                minL = Math.min(r-l+1, minL);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return minL == Integer.MAX_VALUE ? 0 : minL;
    }
}
class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0, r=0;
        int count = 0;
        int max = 0;
        while(r < nums.length){
            if(nums[r] == 0) count++;
            while(count > 1){
                if(nums[l] == 0) count--;
                l++;
            }
            max = Math.max(r-l+1, max);
            r++;
        }
        return max-1;
    }
}
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return fn(nums, k) - fn(nums, k-1);
    }
    private int fn(int[] nums, int k){
        int l = 0, r = 0, count = 0;
        int n = nums.length;
        int[] freq = new int[n+1];
        int distinct = 0;
        while(r < nums.length){
            if(freq[nums[r]] == 0) distinct++;
            freq[nums[r]]++;
            
            while(distinct > k){
                freq[nums[l]]--;
                if(freq[nums[l]] == 0) distinct--;
                l++;
            }
            count = count + (r - l + 1);
            r = r + 1;
        }
        return count;
    }
}
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return fn(nums, k) - fn(nums, k-1);
    }
    private int fn(int[] nums, int k){
        int l = 0, r = 0, count = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        while(r < nums.length){
            mpp.put(nums[r], mpp.getOrDefault(nums[r], 0) + 1);
            while(mpp.size() > k){
                mpp.put(nums[l], mpp.get(nums[l]) - 1);
                if(mpp.get(nums[l]) == 0) mpp.remove(nums[l]);
                l++;
            }
            count = count + (r - l + 1);
            r = r + 1;
        }
        return count;
    }
}
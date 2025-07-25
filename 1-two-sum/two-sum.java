class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int complement = target - nums[i];

            if(mpp.containsKey(complement)){
                return new int[] {mpp.get(complement), i};
            }
            mpp.put(nums[i],i);
        }
        return new int[]{};
    }
}
class Solution {
    //recursive solution
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsetsum(nums,0, res, new ArrayList<Integer>());
        return res;
    }
    private void subsetsum(int[] nums, int index, List<List<Integer>> res, List<Integer> subset){
        if(index == nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        //add the number
        subset.add(nums[index]);
        subsetsum(nums, index+1, res, subset);

        //will not add the nums
        subset.remove(subset.size() - 1);
        subsetsum(nums, index+1, res, subset);
    }
}
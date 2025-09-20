class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permuteUnique(nums, used, res, new ArrayList<>());
        return res;
    }
    private void permuteUnique(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> path){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            path.add(nums[i]);
            permuteUnique(nums, used, res, path);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }
}
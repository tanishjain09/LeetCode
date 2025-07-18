class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, ans, new ArrayList<>());
        return ans;
    }

    public void backtrack(int index, int[] arr, List<List<Integer>> ans , List<Integer> subset){
        ans.add(new ArrayList<>(subset));

        for(int i = index ; i < arr.length; i++){
            if(i!=index && arr[i] == arr[i-1]) continue;

            subset.add(arr[i]);
            backtrack(i+1, arr, ans, subset);
            subset.remove(subset.size()-1);
        }
    }
}
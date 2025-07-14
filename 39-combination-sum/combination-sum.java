class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        finalCombination(0, candidates,target, new ArrayList<>(),ans);
        return ans;
    
    }

    private void finalCombination(int index, int[] arr ,int target, List<Integer> list, List<List<Integer>> ans){
        if(index == arr.length){
            if(target == 0){
            ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        

        if(arr[index] <= target){
            list.add(arr[index]);
            finalCombination(index, arr, target - arr[index], list, ans);
            list.remove(list.size() - 1);
        }
        finalCombination(index + 1, arr, target, list, ans);
    }
}
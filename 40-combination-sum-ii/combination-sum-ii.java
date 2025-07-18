class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        combination(0, target, candidates, ans, new ArrayList<>());
        return ans;
    }

    private void combination(int index, int target, int[] arr, List<List<Integer>> ans, List<Integer> list){
        if(target == 0){
            ans.add(new ArrayList(list));
        }
        for(int i = index; i<arr.length; i++){
            if(i > index && arr[i] == arr[i-1]) continue;
            if(arr[i]>target) break;

            list.add(arr[i]);
            combination(i+1,target-arr[i],arr,ans,list);
            list.remove(list.size()-1);
        }
    }
}
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        combineSubset(1, n, k, ans, new ArrayList<>());
        return ans;
    }
    private void combineSubset(int index, int n, int k, List<List<Integer>> ans, List<Integer> list){
        if(k == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i <= n; i++){
            list.add(i);
            combineSubset(i+1, n,k-1, ans,list);
            list.remove(list.size() - 1);
        }
    }
}
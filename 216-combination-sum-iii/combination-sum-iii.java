class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        finalCombinations(1, k, n, res, new ArrayList<>());
        return res;
    }

    private void finalCombinations(int index, int k, int n, List<List<Integer>> res, List<Integer> list) {
        if(k == 0 && n == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        if(k == 0 || n == 0){
            return;
        }

        for(int i = index; i<=9; i++){
            list.add(i);
            finalCombinations(i+1,k-1,n-i,res,list);
            list.remove(list.size() - 1);
        }
    }
}
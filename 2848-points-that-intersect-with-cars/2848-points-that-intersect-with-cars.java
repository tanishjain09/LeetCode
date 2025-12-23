class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        if(nums == null || nums.size() == 0) return 0;
        List<List<Integer>> merged = new ArrayList<>();    
        Collections.sort(nums, (a,b) ->a.get(0)-b.get(0));

        List<Integer> prev = nums.get(0);
        for(int i = 0; i < nums.size(); i++){
            List<Integer> curr = nums.get(i);
            if(curr.get(0) <= prev.get(1)){
                prev.set(1, Math.max(curr.get(1), prev.get(1)));
            }else{
                merged.add(prev);
                prev = curr;
            }
        }
        merged.add(prev);
        int cnt = 0;
        for(int i = 0; i <merged.size(); i++){
            cnt += (merged.get(i).get(1) - merged.get(i).get(0) + 1);
        }
        return cnt;
    }
}
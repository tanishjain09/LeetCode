class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        int minAbsDiff = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            minAbsDiff = Math.min(minAbsDiff, Math.abs(arr[i-1]-arr[i]));
        }
        for(int i = 1; i < n; i++){
            int diff = Math.abs(arr[i-1]-arr[i]);
            List<Integer> temp = new ArrayList<>();
            if(diff == minAbsDiff){
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                ans.add(temp);
            }
        }
        return ans;
    }
}
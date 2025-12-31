class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length-1;
        while(end - start >= k){
            if(Math.abs(x-arr[start]) > Math.abs(x-arr[end])){
                start++;
            }else{
                end--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = start; i <= end; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}
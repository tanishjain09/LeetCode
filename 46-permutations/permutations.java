class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        allPermu(0, nums, ans);
        return ans;
    }
    private void allPermu(int index, int[] arr, List<List<Integer>> ans){
        if(index == arr.length){
            List<Integer> list = new ArrayList<>();
            for(int num : arr){
                list.add(num);
            }
            ans.add(list);
            return;
        }


        for(int i = index; i < arr.length; i++){
            swap(arr, i, index);
            allPermu(index+1, arr, ans);
            swap(arr,index, i);
        }
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
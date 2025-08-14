class Solution {
    public void nextPermutation(int[] nums) {
        int i =nums.length-1;
        int j =nums.length-1;
        while(i > 0 && nums[i-1] >= nums[i]){
            i--;
        }
        if(i == 0){
            reverse(nums, 0, nums.length-1);
            return;
        }
        while(j >= i && nums[j] <= nums[i-1]){
            j--;
        }

        swap(nums, i-1, j);
        reverse(nums, i, nums.length-1);
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void reverse(int[] arr, int i, int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
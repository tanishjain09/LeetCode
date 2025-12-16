class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum  =0;
        for(int num : nums) sum += num;
        if(sum % k != 0)return false;
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        reverse(nums);
        return canPart(nums, vis, 0, k, 0, sum/k);
    }
    private boolean canPart(int[] arr, boolean[] vis, int start, int k, int currSum, int target){
        if(k == 0){
            return true;
        }
        if(currSum == target) return canPart(arr, vis, 0, k-1, 0, target);
        for(int i = 0; i < arr.length; i++){
            if(vis[i]) continue;
            if(currSum + arr[i] > target) continue;
            vis[i] = true;
            if(canPart(arr, vis, i+1, k, currSum + arr[i], target)){
                return true;
            }
            vis[i] = false;

            if (currSum == 0) break;
            while (i + 1 < arr.length && arr[i] == arr[i + 1]) i++;
        }
        return false;
    }
    void reverse(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }
}
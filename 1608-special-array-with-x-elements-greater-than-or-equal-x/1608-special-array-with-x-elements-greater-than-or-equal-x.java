class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = n;

        while(left <= right){
            int mid = left + (right - left) / 2;
            int count = countGE(nums, mid);

            if(count == mid){
                return mid;
            }else if(count > mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        } 
        return -1;
    }

    private int countGE(int[] nums, int x){
        int n = nums.length;
        int left = 0, right = n-1;

        while(left <= right){
            int mid = left + (right - left) /2;
            if(nums[mid] >= x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return n - left;
    }
}
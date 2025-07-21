class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(max,num);
        }

        int low = min;
        int high = max;
        int ans = -1;
        while(low <= high){
            int mid = (low + high) /2;
            if(div(nums,mid) <= threshold){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private int div(int[] arr, int div){
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += Math.ceil((double)arr[i] / (double)div);
        }
        return sum;
    }
}
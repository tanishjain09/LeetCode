class Solution {
    public int search(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] == k) return mid;
            if(arr[low] <= arr[mid]){
                if(arr[low] <= k && k <= arr[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(arr[mid] <= k && k <= arr[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
class Solution {
    public int findMin(int[] arr) {

        //as per analysis the min is always the next index of pivot if arrary is rotated 
        //and if array is not rotate means pivot will be -1 as we define the pivot method
        int pivot = findPivot(arr);
        return arr[pivot + 1];
    }

    //first find the pivot that is largest in the array index
    private int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid ;
            }
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }

            if(arr[mid] <= arr[start]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1; // this means that the array is not rotated 
    }
}
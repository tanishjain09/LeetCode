class Solution {
    public int search(int[] arr, int target) {
        int Pivot = findPivot(arr);
        if(Pivot == -1){
          
            return binarySearch(arr, target, 0, arr.length-1);
        }
        //if you have found ,you have two asc sorted array
        if(arr[Pivot]==target){
            return Pivot;
        }
        if(target>=arr[0] ){
            return binarySearch(arr, target, 0, Pivot-1);
        }
    
            return binarySearch(arr, target, Pivot+1, arr.length-1);
            
        }
    
    public int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid>start && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            if(arr[mid]<=arr[start]){
                end = mid-1;
            }else{
            start = mid+1;
            }
        }
        return -1;
    }
    public int binarySearch(int[] arr, int target, int start, int end){
         while (start<=end) {
           // int mid = (start+end)/2 -> might be possible that (start+end) excced the int limit

           int mid = start + (end - start)/2;

           if(target<arr[mid]){
            end = mid-1;
           }else if(target>arr[mid]){
            start = mid+1;
           }else{
            return mid;
           }
        }
        return -1;
    }
}


/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        int peak = getPeak(mountainArr, n);

        int index = binarySearch(target, mountainArr, 0, peak, true);
        if(index != -1) return index;

        return binarySearch(target, mountainArr, peak+1, n-1, false);
    }
    private int getPeak(MountainArray mountainArr, int n){
        int low = 0;
        int high = n-1;

        while(low < high){
            int mid = low + (high - low)/2;
            int midVal = mountainArr.get(mid);
            int midNextVal = mountainArr.get(mid + 1);
            if(midVal < midNextVal){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    private int binarySearch(int target, MountainArray mountainArr, int start, int end, boolean isAscending){

        while(start <= end){
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            if(target == midVal){
                return mid;
            }
            if(isAscending){
                if(target < midVal){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                if(target > midVal){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
        }
        return -1; 
    }
}
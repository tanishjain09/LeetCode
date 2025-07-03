class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int i = 0;
        while (i < n){
            if (isIndexPresent(arr,i)) {
                i++;
            }else{
                return i;
            }
        }
        return i;
    }
    private boolean isIndexPresent(int[] arr,int target){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target){
                return true;
            }
        }
        return false;
    }
}
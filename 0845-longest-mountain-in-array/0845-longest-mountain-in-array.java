class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int max = 0;
        if(n < 3) return 0;
        int left = 0;
        int right = 0;
        for(int i = 1; i < arr.length-1; i++){
            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]){
                left = i;
                right = i;
                while(left > 0 && arr[left] > arr[left-1]){
                    left--;
                }
                while(right < n-1 && arr[right+1] < arr[right]){
                    right++;
                }
                max = Math.max(max, right-left+1);
            }
        }
        return max;
    }
}
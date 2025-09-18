class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int windowSum = 0;
        int n = arr.length;
        for(int i = 0; i < k; i++){
            windowSum += arr[i];
        }
        if(windowSum >= k * threshold) count++;
        for(int i = k; i < n; i++){
            windowSum = windowSum + arr[i] - arr[i-k];
            if(windowSum >= k * threshold) count++;
        }
        return count;
    }
}
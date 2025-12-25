class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        reverse(happiness, 0, n-1);
        long sum = 0;
        int dec = 0;
        for(int i = 0; i < k; i++){
            if( happiness[i] - (long)dec > 0) sum = sum + happiness[i] - (long)dec;
            dec++;
        }
        return sum;
    }
    private void reverse(int[] arr, int i, int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        reverse(capacity, 0, capacity.length-1);
        int sumApple = 0;
        for(int i = 0; i < apple.length; i++){
            sumApple += apple[i];
        }
        int cnt = 0;
        for(int i = 0; i < capacity.length; i++){
            sumApple -= capacity[i];
            cnt++;
            if(sumApple <= 0) return cnt;
        }
        return 0;
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
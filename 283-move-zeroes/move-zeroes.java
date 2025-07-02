class Solution {
    public void moveZeroes(int[] arr) {
        int n = arr.length;

        //find the first occurence of 0 and store it in j
        int j = -1;
        for (int i = 0; i < n; i++) {
            if(arr[i] == 0){
                j = i;
                break;
            }
        }
        //using two pointer check if element at i is 0 or not if not than swap the 0 with ith element and if ith element is zero than just increment i and check for next index
        if(j > -1){
            for(int i = j+1; i<n; i++) {
                if (arr[i] != 0) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    j++;
                }
            }
        }
    }
}
class Solution {
    public int missingNumber(int[] arr) {
        //optimised solution after applying the sum of n number concept
        int n = arr.length;
        int sumOfNNumber = (n * (n+1) ) /2;
        int sumOfArray = 0;
        for(int i = 0; i< arr.length; i++){
            sumOfArray += arr[i];
        }
        return sumOfNNumber - sumOfArray;
    }
}
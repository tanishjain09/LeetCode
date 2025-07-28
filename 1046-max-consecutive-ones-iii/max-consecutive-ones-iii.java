class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int max =0;
        int count = 0; //count the number of zeroes in the current window
        while(j < nums.length){
            if(nums[j] == 0){
                count++;
            }

            while(count > k){ //shrinking of window of the the count get more than k
                if(nums[i] == 0){
                    count--;
                }
                i++;
            }
            max = Math.max(max, j - i + 1);

            j++;
        }
        return max;
    }
}
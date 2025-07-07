class Solution {
    public int singleNonDuplicate(int[] nums) {
        //the brute force approach of O(n) is XOR

        int unique = 0;
        for(int num : nums){
            unique ^= num;
        }
        return unique;
    }
}
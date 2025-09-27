class Solution {
    public int rob(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev = nums[start];

        for(int i= start; i < end; i++){
            int taken = nums[i];
            if(i - start> 1) taken += prev2;
            int notTaken = 0 + prev;
            int curri = Math.max(taken, notTaken);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;

        int ans1 = rob(nums, 0, n-1);
        int ans2 = rob(nums, 1, n);
        return Math.max(ans1, ans2);
    }
}
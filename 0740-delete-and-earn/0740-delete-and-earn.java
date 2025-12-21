class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num : nums) max = Math.max(max, num);
        int[] earn = new int[max+1];
        for(int num : nums) earn[num] += num;
        int prev = earn[0];
        int prev2 = 0;
        for(int ind = 1; ind <= max; ind++){
            int curr = Math.max(prev, prev2+earn[ind]);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
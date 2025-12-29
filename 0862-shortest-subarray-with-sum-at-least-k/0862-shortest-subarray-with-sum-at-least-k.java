class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long[] cumSum = new long[nums.length];
        Deque<Integer> dq = new ArrayDeque<>();
        int minL = Integer.MAX_VALUE;
        int l = 0, r = 0;
        while(r < nums.length){
           if(r == 0) cumSum[r] = nums[r];
           else cumSum[r] = cumSum[r-1] + nums[r];
           //subarray start from 0
           if(cumSum[r] >= k){
                minL = Math.min(minL, r+1);
           }
           while(!dq.isEmpty() && cumSum[r] - cumSum[dq.peekFirst()] >= k){
            minL = Math.min(minL, r-dq.peekFirst());
            dq.pollFirst();
           }
           while(!dq.isEmpty() && cumSum[r] <= cumSum[dq.peekLast()]){
            dq.pollLast();
           }
           dq.offerLast(r);
           r++;
        }
        return minL == Integer.MAX_VALUE?-1:minL;
    }
}
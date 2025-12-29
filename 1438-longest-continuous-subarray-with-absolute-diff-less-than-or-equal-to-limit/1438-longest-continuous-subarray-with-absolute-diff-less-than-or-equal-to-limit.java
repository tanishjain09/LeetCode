class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> minPq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> maxPq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        int l = 0, r = 0;
        int maxL = 0;
        while(r < nums.length){
            minPq.add(new int[]{nums[r], r});
            maxPq.add(new int[]{nums[r], r});
            while(maxPq.peek()[0]-minPq.peek()[0] > limit){
                l = Math.min(maxPq.peek()[1], minPq.peek()[1]) + 1; 
                while(maxPq.peek()[1] < l){
                    maxPq.poll();
                }
                while(minPq.peek()[1] < l){
                    minPq.poll();
                }
            }
            maxL = Math.max(maxL, r-l+1);
            r++;
        } 
        return maxL;
    }
}
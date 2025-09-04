class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deck = new ArrayDeque<>();
        int index = 0;

        for(int i = 0; i < n; i++){
            if(!deck.isEmpty() && deck.peek() <= i - k){
                deck.poll();
            }
            while(!deck.isEmpty() && nums[deck.peekLast()] < nums[i]){
                deck.pollLast();
            }
            deck.offer(i);
            if(i >= k - 1){
                res[index++] = nums[deck.peek()];
            }
        }
        return res;
    }
}
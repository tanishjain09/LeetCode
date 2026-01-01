class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(b, a));
        for(int stone : stones) maxHeap.add(stone);
        while(maxHeap.size() > 1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            maxHeap.offer(first -second);
        }
        return maxHeap.peek();
    }
}
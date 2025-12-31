class Solution {
    public int minStoneSum(int[] piles, int k) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int pile : piles) pq.add(pile);

        for(int i = 0; i < k; i++){
            if(!pq.isEmpty()){
                int pile = pq.poll();
                pile = pile - pile/2;
                pq.offer(pile);
            }
        }
        while(!pq.isEmpty()){
            ans += pq.poll();
        }
        return ans;
    }
}
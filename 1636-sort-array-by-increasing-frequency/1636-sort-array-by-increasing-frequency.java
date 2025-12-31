class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            if(map.get(a) != map.get(b)) return map.get(a) - map.get(b);
            return b-a;
        });
        for(int num : nums) pq.add(num);
        int[] ans = new int[nums.length];
        int i = 0;
        while(!pq.isEmpty()){
            ans[i++]= pq.poll();
        }
        return ans;
    }
}
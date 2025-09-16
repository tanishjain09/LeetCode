class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();

        for(char t: tasks){
            freq.put(t, freq.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        maxHeap.addAll(freq.values());

        Queue<int[]> cooldown = new LinkedList<>();

        int time = 0;
        while(!maxHeap.isEmpty() || !cooldown.isEmpty()){
            time++;

            if(!maxHeap.isEmpty()){
                int count = maxHeap.poll() -1;
                if(count > 0){
                    cooldown.add(new int[]{count, time + n});
                }
            }

            if(!cooldown.isEmpty() && cooldown.peek()[1] == time){
                maxHeap.add(cooldown.poll()[0]);
            }
        }
        return time;
    }
}
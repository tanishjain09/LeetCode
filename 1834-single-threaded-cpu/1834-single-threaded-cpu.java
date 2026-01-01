class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sorted = new int[n][3];
        int[] res = new int[n];
        int resIdx= 0;
        for(int i = 0; i < n; i++){
            sorted[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(sorted, (a,b) -> a[0]- b[0]);
        int[] result = new int[n];
        //pq -> processing time, index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        int currTime = 0;
        int idx = 0;
        while(idx < n || !pq.isEmpty()){
            if(pq.isEmpty() && currTime < sorted[idx][0]){
                currTime = sorted[idx][0];
            }
            while(idx < n && sorted[idx][0] <= currTime){
                pq.add(new int[]{sorted[idx][1], sorted[idx][2
                ]});
                idx++;
            }
            int[] task = pq.poll();
            currTime += task[0];
            res[resIdx++] = task[1];
        }
        return res;
    }
}
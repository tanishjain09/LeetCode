class Pair{
        int node;
        int dist;
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++)adj.add(new ArrayList<>());
        for(int i = 0; i < times.length; i++){
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        pq.add(new Pair(k, 0));
        dist[k] = 0;

        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int dis = pq.peek().dist;
            pq.remove();

            for(Pair p : adj.get(node)){
                int adjNode = p.node;
                int edgeWt = p.dist;
                if(dis + edgeWt < dist[adjNode]){
                    dist[adjNode] = dis + edgeWt;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        int maxTime = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
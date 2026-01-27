class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int minCost(int n, int[][] edges) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adjList.get(u).add(new Pair(v, wt));
            adjList.get(v).add(new Pair(u, 2*wt));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> a.dist-b.dist);
        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int node = top.node;
            int d = top.dist;

            if(d > dist[node]) continue;
            if(node == n-1) return d;
            
            for(Pair p : adjList.get(node)){
                int adjNode = p.node;
                int wt = p.dist;

                if(d + wt < dist[adjNode]){
                    dist[adjNode] = d+wt;
                    pq.offer(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        return -1;
    }
}
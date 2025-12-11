class Pair{
    int node;
    int dist;
    public Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}

class Tuple{
    int stop;
    int node;
    int dist;
    public Tuple(int stop, int node, int dist){
        this.stop = stop;
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < flights.length; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        q.add(new Tuple(0, src, 0));
        dist[src] = 0;

        while(!q.isEmpty()){
            int node = q.peek().node;
            int stop = q.peek().stop;
            int dis = q.peek().dist;
            q.remove();
            if(stop > k) continue;
            for(Pair p : adj.get(node)){
                int adjNode = p.node;
                int edgeWt = p.dist;

                if(dis + edgeWt < dist[adjNode] && stop <= k){
                    dist[adjNode] = dis + edgeWt;
                    q.add(new Tuple(stop+1, adjNode, dist[adjNode]));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
         return dist[dst];
    }
}
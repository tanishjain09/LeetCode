class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
    
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adjList.get(v).add(u);
            adjList.get(u).add(v);
        }
        return dfs(source, destination, adjList, vis);
    }
    private boolean dfs(int src, int dst, List<List<Integer>> adjList, boolean[] vis){
        if(src == dst) return true;
        vis[src] = true;
        for(int adjNode : adjList.get(src)){
            if(!vis[adjNode]){
                if(dfs(adjNode, dst, adjList, vis)){
                    return true;
                }
            }
        }
        return false;
    }
}
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++) adjList.add(new ArrayList<>());
        for(int i = 0; i < dislikes.length; i++){
            int u = dislikes[i][0];
            int v = dislikes[i][1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int[] color = new int[n+1]; 
        Arrays.fill(color, -1);
        for(int i = 1; i <= n; i++){
            if(color[i] == -1){
                if(!check(i, 0, adjList, color)) return false;
            }
        }
        return true;
    }
    private boolean check(int node, int col, List<List<Integer>> adjList, int[] color){
        color[node] = col;
        for(int adjNode : adjList.get(node)){
            if(color[adjNode] == -1){
                if(!check(adjNode, 1-col, adjList, color)){
                    return false;
                }
            }else if(color[adjNode] == color[node]){
                return false;
            }
        }
        return true;
    }
}
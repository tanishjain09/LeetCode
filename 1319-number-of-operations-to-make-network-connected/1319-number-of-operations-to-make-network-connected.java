class Solution {
    class DisjointSet{
        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> size = new ArrayList<>();
        public DisjointSet(int n){
            for(int i = 0; i <=  n; i++){
                parent.add(i);
                size.add(1);
            }
        }
        public int findParent(int node){
            if(parent.get(node) == node) return node;
            int ulp = findParent(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }
        public void unionBySize(int u, int v){
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);
            if(ulp_u == ulp_v) return;
            if(size.get(ulp_u) < size.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            }else{
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);

        int ans = 0;
        int extra = 0;
        for(int i = 0; i < connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findParent(u) == ds.findParent(v)){
                extra++;
            }else{
                ds.unionBySize(u, v);
            }
        }
        for(int i = 0; i < n; i++){
            if(ds.findParent(i) == i) ans++;
        }
        if(extra >= ans-1){
            return ans-1;
        }else{
            return -1;
        }
    }
}
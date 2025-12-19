
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        adj.get(0).add(new int[]{firstPerson, 0});
        for(int i = 0; i < meetings.length; i++){
            int u = meetings[i][0];
            int v = meetings[i][1];
            int t = meetings[i][2];
            adj.get(u).add(new int[]{v, t});
            adj.get(v).add(new int[]{u,t});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        int[] know = new int[n];
        Arrays.fill(know, Integer.MAX_VALUE);
        know[0] = 0;
        q.add(new int[]{0, 0});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int u = curr[0];
            int tu = curr[1];
            if (tu > know[u]) continue;
            for(int[] edge: adj.get(u)){
                int v = edge[0];
                int tv = edge[1];
                if(tu <= tv && tv < know[v]){
                    know[v] = tv;
                    q.add(new int[]{v, tv});
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(know[i] != Integer.MAX_VALUE) ans.add(i);
        }
        return ans;
    }
}
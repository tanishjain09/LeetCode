class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int[] vis = new int[n];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = 1;
        while(!q.isEmpty()){
            int room = q.poll();
            for(int adjRoom : rooms.get(room)){
                if(vis[adjRoom] == 0){
                    vis[adjRoom] = 1;
                    q.add(adjRoom);
                }
            }
        }
        for(int num : vis){
            if(num == 0) return false;
        }
        return true;
    }
}
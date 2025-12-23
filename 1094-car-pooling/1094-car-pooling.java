class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> events = new ArrayList<>();

        for(int[] trip : trips){
            events.add(new int[]{trip[1], trip[0]});
            events.add(new int[]{trip[2], -trip[0]});
        }
        Collections.sort(events, (a,b)->{
            return a[0]==b[0]?a[1]-b[1]:a[0]-b[0];
        });

        int cnt =0;
        for(int[] it : events){
            cnt += it[1];
            if(cnt > capacity) return false;
        }
        return true;

    }
}
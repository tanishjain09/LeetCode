class Solution {
    class Tuple{
        int x;
        int y;
        double dis;
        public Tuple(int x, int y, double dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> Double.compare(b.dis,a.dis));

        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            double dis =(x*x+y*y);
            pq.offer(new Tuple(x, y, dis));
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++){
            Tuple top = pq.poll();
            ans[i][0] = top.x;
            ans[i][1] = top.y;
        }
        return ans;
    }
}
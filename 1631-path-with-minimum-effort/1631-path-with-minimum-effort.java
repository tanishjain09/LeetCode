class Tuple{
    int row;
    int col;
    int dist;
    public Tuple(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        pq.add(new Tuple(0, 0, 0));
        dist[0][0] = 0;
        while(!pq.isEmpty()){
            int row = pq.peek().row;
            int col = pq.peek().col;
            int diff = pq.peek().dist;
            pq.remove();

            for(int i = 0; i < 4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && nrow < n
                && ncol >= 0 && ncol < m){
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), diff);
                    if(newEffort < dist[nrow][ncol]){
                        dist[nrow][ncol] = newEffort;
                        pq.add(new Tuple(nrow, ncol, newEffort));
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}
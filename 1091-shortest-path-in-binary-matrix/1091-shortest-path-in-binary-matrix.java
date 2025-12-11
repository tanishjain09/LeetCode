class Pair{
    int row;
    int col;
    int dist;
    public Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] != 0 || grid[n-1][m-1] != 0) return -1;
        int[][] dist = new int[n][m];
        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.dist - b.dist
        );
        pq.add(new Pair(0, 0, 1));
        dist[0][0] = 1;
        while(!pq.isEmpty()){
            int row = pq.peek().row;
            int col = pq.peek().col;
            int dis = pq.peek().dist;
            pq.remove();
            if(row == n-1 && col == m-1) return dis;
            for(int drow = -1; drow <= 1; drow++){
                for(int dcol = -1; dcol <= 1; dcol++){
                    int nrow = drow + row;
                    int ncol = dcol + col;
                    if(nrow >= 0 && nrow < n
                    && ncol >= 0 && ncol < m
                    && dis + 1 < dist[nrow][ncol]
                    && grid[nrow][ncol] == 0){
                        dist[nrow][ncol] = dis + 1;
                        if(nrow == n-1 && ncol == m-1) return dis + 1;
                        pq.add(new Pair(nrow, ncol, dist[nrow][ncol]));
                    }
                }
            }
        }
        return -1;
    }
}
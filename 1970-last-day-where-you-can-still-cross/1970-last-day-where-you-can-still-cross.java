class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int low = 0;
        int high = cells.length-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high -low)/2;
            if(bfs(row, col, mid, cells)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    private boolean bfs(int row, int col, int n, int[][] cells){
        int[][] grid = new int[row][col];
        for(int k= 0; k < n; k++){
            int i = cells[k][0] - 1;
            int j = cells[k][1] - 1;
            grid[i][j] = 1;
        }
        Queue<Pair> q = new LinkedList<>();
        for(int j = 0; j < col; j++){
            if(grid[0][j] == 0){
                q.add(new Pair(0, j));
                grid[0][j] = 1;
            }
        }
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();
            if(r==row-1) return true;
            int[] drow = {-1,0,1,0};
            int[] dcol = {0,1,0,-1};
            for(int i = 0; i < 4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >= 0 && nrow < row
                && ncol >= 0 && ncol < col
                && grid[nrow][ncol] == 0){
                    q.add(new Pair(nrow, ncol));
                    grid[nrow][ncol] = 1;
                }
            }
        }
        return false;
    }
}
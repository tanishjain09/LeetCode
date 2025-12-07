class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1' && vis[row][col] == 0) {
                    cnt++;
                    // bfs(row, col, vis, grid);
                    dfs(row, col, grid);
                }
            }
        }
        return cnt;
    }

    private void bfs(int ro, int co, int[][] vis, char[][] grid) {

        Queue<Pair> q = new LinkedList<Pair>();
        vis[ro][co] = 1;
        q.add(new Pair(ro, co));
        int n = grid.length;
        int m = grid[0].length;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if (nrow >= 0 && nrow < n &&
                        ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 &&
                        grid[nrow][ncol] == '1') {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
    private void dfs(int ro, int co, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        if (ro < 0 || ro >= n || co < 0 || co >= m || grid[ro][co] == '0') {
            return;
        }

        grid[ro][co] = '0';

        dfs(ro-1, co, grid); //up
        dfs(ro, co+1, grid); //right
        dfs(ro+1, co, grid); // down
        dfs(ro, co-1, grid); //left
    }
}
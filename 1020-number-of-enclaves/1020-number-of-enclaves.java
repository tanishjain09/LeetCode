class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        //uppar and lower row
        for(int j = 0; j < m; j++){
            if(grid[0][j] == 1 && vis[0][j] == 0){
                dfs(0, j, grid, vis);
            }
            if(grid[n-1][j] == 1 && vis[n-1][j] == 0){
                dfs(n-1, j, grid, vis);
            }
        }
        //for front col and end col
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1 && vis[i][0] == 0){
                dfs(i, 0, grid, vis);
            }
            if(grid[i][m-1] == 1 && vis[i][m-1] == 0){
                dfs(i, m-1, grid, vis);
            }
        }
        int count=0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) count++;
            }
        }
        return count;
    }
    private void dfs(int ro, int co, int[][] grid, int[][] vis){
        int n = grid.length;
        int m = grid[0].length;
        if(ro < 0 || ro >= n || co < 0 || co >= m || vis[ro][co] == 1 || grid[ro][co] == 0) return;
        vis[ro][co] = 1;
        grid[ro][co] = 0;
        dfs(ro+1, co, grid, vis);
        dfs(ro-1, co, grid, vis); 
        dfs(ro, co+1, grid, vis); 
        dfs(ro, co-1, grid, vis);

    }
}
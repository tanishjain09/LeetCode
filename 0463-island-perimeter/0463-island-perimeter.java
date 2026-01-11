class Solution {
    int para = 0;
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    dfs(i, j, grid, vis);
                }
            }
        }
        return para;
    }
    private void dfs(int ro, int co, int[][] grid, int[][] vis){
        int n = grid.length;
        int m = grid[0].length;
        if(ro < 0 || ro >= n || co < 0 || co >= m ){
            para++;
            return;
        } 
        if(vis[ro][co] == 1) return;
        
        if(grid[ro][co] == 0){
            para++;
            return;
        }
        vis[ro][co] = 1;
        dfs(ro+1, co, grid, vis);
        dfs(ro-1, co, grid, vis); 
        dfs(ro, co+1, grid, vis); 
        dfs(ro, co-1, grid, vis);
    }
}
class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] vis = new int[n][m];
        int[][] ans = image;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int originalColor = image[sr][sc];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        vis[sr][sc] = 1;
        ans[sr][sc] = color;
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();

            for(int i = 0; i < 4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >= 0 && nrow < n
                && ncol >= 0 && ncol <m
                && vis[nrow][ncol] == 0
                && image[nrow][ncol] == originalColor){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                    ans[nrow][ncol] = color;
                }
            }
        }
        return ans;
    }
}
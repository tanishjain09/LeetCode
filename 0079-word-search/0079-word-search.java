class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(word.charAt(0) == board[i][j]){
                    if(backtrack(i, j, 0, board, vis, word))return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(int r, int c, int ind,char[][] board, boolean[][] vis, String word){
        int m = board.length;
        int n = board[0].length;
        if(ind == word.length()){
            return true;
        }
        if(r >= m || r < 0 || c < 0 || c >= n || vis[r][c] || word.charAt(ind) != board[r][c]) return false;
        
        vis[r][c] = true;
        boolean found = backtrack(r-1,c,ind+1,board,vis,word) || 
                        backtrack(r,c+1,ind+1,board,vis,word) ||
                        backtrack(r+1,c,ind+1,board,vis,word) ||
                        backtrack(r,c-1,ind+1,board,vis,word);
        vis[r][c] = false;
        return found;
    }
}
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<>();
        solve(0, board, res);
        return res;
    }
    private void solve(int col, char[][] board, List<List<String>> res){
        if(col == board.length){
            res.add(construct(board));
            return;
        }
        for(int row = 0; row < board.length; row++){    
            if(isValid(row, col, board)){
                board[row][col] = 'Q';
                solve(col+1, board, res);
                board[row][col] = '.';
            }
        }
    }
    private boolean isValid(int row, int col, char[][] board){
        int dupRow = row;
        int dupCol = col;

        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }
        col = dupCol;
        while(row < board.length && col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }
    private List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            String str = new String(board[i]);
            res.add(str);
        }
        return res;
    }
}
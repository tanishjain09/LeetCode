class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        return backtrack(0, board);
    }



    private int backtrack(int col, char[][] board){
        if(col == board.length){
            return 1;
        }
        int count = 0;
        for(int row = 0; row < board.length; row++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                count = count + backtrack(col+1, board);
                board[row][col] = '.';
            }
        }
        return count;
    }

    private boolean isSafe(char[][] board, int row, int col){
        int dupRow = row;
        int dupCol = col;

        while(row >= 0 && col>= 0){
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
            row++;
            col--;
        }
        return true;
    }
}
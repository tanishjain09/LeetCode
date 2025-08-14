class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        List<List<String>> result= new ArrayList<>();
        backtrack(0, board, result);
        return result;
    }

    private void backtrack(int col, char[][] board,List<List<String>> result){
        if(col == board.length){
            result.add(construct(board));
            return;
        }

        for(int row = 0; row < board.length; row++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                backtrack(col+1, board, result);
                board[row][col] = '.';
            }
        }
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


    private List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
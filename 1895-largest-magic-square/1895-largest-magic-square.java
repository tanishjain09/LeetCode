class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int side = Math.min(m,n);
        while(side> 0){
            for(int i = 0; i < n; i++){
                for(int j = 0; j< m; j++){
                    if(i+side <= n && j+side <= m){
                        if(isValid(grid,n,m,i,j,side)) return side;
                    }
                }
            }
            side--;
        }
        return 0;
    }
    private boolean isValid(int[][] grid, int n, int m, int i, int j, int side){
        int sum = 0;
        for(int x = i; x < i+side; x++){
            int currSum = 0;
            for(int y = j; y < j+side; y++){
                currSum += grid[x][y];
            }
            if(x == i) sum = currSum;
            else if(sum != currSum) return false;
        }

        for(int x = j; x < j + side; x++){
            int currSum = 0;
            for(int y = i; y < i + side; y++){
                currSum += grid[y][x];
            }
            if(sum != currSum) return false;
        }

        int currSum = 0;
        for(int k = 0; k < side; k++){
            currSum += grid[i+k][j+k];
        }
        if(sum != currSum) return false;

        currSum = 0;
        for(int k = 0; k < side; k++){
            currSum += grid[i + k][j + side - 1 - k];
        }
        if(sum != currSum) return false;
        return true;
    }
}
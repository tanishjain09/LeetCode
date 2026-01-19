class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] pref = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                pref[i][j] = mat[i][j] 
                            + (i > 0 ? pref[i-1][j] : 0)
                            + (j > 0 ? pref[i][j-1] : 0)
                            - (i > 0 && j > 0 ? pref[i-1][j-1] : 0);
            }
        }
        int low = 1, high = Math.min(rows, cols);
        int result = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(check(mid, rows, cols, threshold, pref)){
                result = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return result;
    }
    private boolean check(int n, int rows, int cols, int x, int[][] pref){
        if(n == 0) return true;

        for(int i = 0; i + n - 1 < rows; i++){
            for(int j = 0; j + n - 1 < cols; j++){

                int r2 = i + n - 1;
                int c2 = j + n - 1;

                int sum = pref[r2][c2];
                if(i > 0) sum -= pref[i-1][c2];
                if(j > 0) sum -= pref[r2][j-1];
                if(i > 0 && j > 0) sum += pref[i-1][j-1];

                if(sum <= x){
                    return true;
                }
            }
        }
        return false;
    }
}
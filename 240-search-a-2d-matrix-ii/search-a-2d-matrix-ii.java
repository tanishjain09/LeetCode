class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int n = matrix[0].length;
        int col = n - 1;

        while(row < matrix.length && col >=0 ){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}
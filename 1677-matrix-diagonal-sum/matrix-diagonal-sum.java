class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int sum = 0;

        for(int i=0; i<n; i++){
            sum+= mat[i][i];
            if(i != mat.length- 1- i){
                sum+=mat[i][ mat.length- 1- i];
            }
            }
            return sum;
        }
        
    }

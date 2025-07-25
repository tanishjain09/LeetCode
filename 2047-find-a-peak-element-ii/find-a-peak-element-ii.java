class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m-1;

        while(low <= high){
            int mid = (low + high) / 2;
            int maxInRowIndex = maxElementIdx(mat, n, mid);
            int left = (mid-1) >= 0? mat[maxInRowIndex][mid-1]: -1;
            int right = (mid+1) < m? mat[maxInRowIndex][mid+1]: -1;
            if(mat[maxInRowIndex][mid] > left && mat[maxInRowIndex][mid] > right){
                return new int[] {maxInRowIndex,mid};
            }
            else if(mat[maxInRowIndex][mid] < left){
                high = mid - 1;
            }else{
                low = mid +1;
            }
        }
        return new int[] {-1,-1};
    }
    
    private int maxElementIdx(int[][] mat, int n, int col){
        int index=-1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(max < mat[i][col]){
                max = mat[i][col];
                index = i;
            }
        }
        return index;
    }
}
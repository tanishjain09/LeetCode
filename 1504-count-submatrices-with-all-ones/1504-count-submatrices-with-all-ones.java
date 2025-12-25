class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int result =0;
        for(int startRow = 0; startRow < n; startRow++){
            int[] vec = new int[m];
            Arrays.fill(vec, 1);
            for(int endRow = startRow; endRow < n; endRow++){
                for(int col = 0; col < m; col++){
                    vec[col] = vec[col] & mat[endRow][col];
                }

                result += onedArrayCnt(vec);
            }
        }
        return result;
    }
    private int onedArrayCnt(int[] arr){
        int cons = 0;
        int subCont = 0;
        for(int it : arr){
            if(it == 0) cons = 0;
            else cons++;
            subCont += cons;
        }
        return subCont;
    }
}
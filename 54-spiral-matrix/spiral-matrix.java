class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> result = new ArrayList<>();

        int n = arr.length;
        int m = arr[0].length;
        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n -1;

        while (top <= bottom && left <= right ){
            for(int i = left; i <= right; i++){
                result.add(arr[top][i]);
            }
            top++;
            for(int i = top; i <= bottom; i++){
                result.add(arr[i][right]);
            }
            right--;
            //check here that if the top is still greater equal to bottom
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    result.add(arr[bottom][i]);
                }
                bottom--;
            }
            //here we check  for left and still greater than equal to right
            if(left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(arr[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
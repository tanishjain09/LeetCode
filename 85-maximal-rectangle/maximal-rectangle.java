class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;
        int[][] preSum = new int[n][m];
        for(int j = 0; j < m; j++){
            int sum = 0;
            for(int i = 0; i < n; i++){
                if(matrix[i][j] == '1') sum += 1;
                else sum = 0;
                preSum[i][j] = sum;
            }
        }
        for(int i = 0; i < n; i++){
            maxArea = Math.max(maxArea, largestRectangleArea(preSum[i]));
        }
        return maxArea;
    }


    private int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int nse = 0, pse = 0;
        int element =-1;
        int n = heights.length;
        for(int i =0;i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                element = stack.pop();
                nse = i;
                pse = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, (nse - pse - 1) * heights[element]);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            nse = n;
            element = stack.pop();
            pse = stack.isEmpty() ? -1: stack.peek();
            maxArea = Math.max(maxArea, (nse - pse - 1) * heights[element]);
        }
        return maxArea;
    }
}
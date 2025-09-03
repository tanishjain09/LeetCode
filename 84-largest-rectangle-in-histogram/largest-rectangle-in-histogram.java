class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int element = -1;
        int nse = 0, pse = 0;

        for(int i =0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                element = stack.pop();;
                nse = i;
                pse = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, (nse - pse - 1) * heights[element]);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            nse = n;
            element = stack.pop();
            pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, (nse - pse - 1) * heights[element]);
        }
        return maxArea;
    }
}
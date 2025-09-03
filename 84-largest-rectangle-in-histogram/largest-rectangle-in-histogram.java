class Solution {
    public int largestRectangleArea(int[] arr) {
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);

        int max = 0;
        for(int i = 0; i < arr.length; i++){
            max=  Math.max(max, arr[i] * (nse[i] - pse[i] - 1));
        }
        return max;
    }
    private int[] findNSE(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[n];
        for(int i = n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            nse[i] = stack.isEmpty()? n: stack.peek();
            stack.push(i);
        }
        return nse;
    }

    private int[] findPSE(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[n];
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            pse[i] = stack.isEmpty()? -1: stack.peek();
            stack.push(i);
        }
        return pse;
    }
}
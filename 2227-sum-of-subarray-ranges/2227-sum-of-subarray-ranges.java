class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums)-sumSubarrayMins(nums);
    }

    public long sumSubarrayMins(int[] arr) {
        int[] nse = getNSE(arr);
        int[] pse = getPSE(arr);
        long total = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            total += (long) right * left * arr[i] ;
        }
        return total;
    }

    private int[] getNSE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    private int[] getPSE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] pse = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

    public long sumSubarrayMax(int[] arr) {
        int[] nge = findNGE(arr);
        int[] pge = findPGE(arr);
        long total = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i - pge[i];
            int right = nge[i] - i;
            total += (long) left * right * arr[i];
        }
        return total;
    }

    private int[] findNGE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] nge = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nge;
    }

    private int[] findPGE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] pge = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pge;
    }
}
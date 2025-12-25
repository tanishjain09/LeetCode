class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int n = pushed.length;
        int ind = 0;
        for(int i = 0; i < n; i++){
            st.push(pushed[i]);
            while(!st.isEmpty() && st.peek() == popped[ind]){
                st.pop();
                ind++;
            }
        }
        return st.size() == 0 ? true : false;
    }
}
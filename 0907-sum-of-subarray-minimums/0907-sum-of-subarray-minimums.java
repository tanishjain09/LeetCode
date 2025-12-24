class Solution {
    public int sumSubarrayMins(int[] arr) {
        //solution using dp
        int n = arr.length;
        int MOD = (int) 1e9 + 7;
        Stack<Integer> st = new Stack<>();
        long[] dp = new long[n];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            int nse = st.isEmpty() ? -1 : st.peek();
            

            dp[i] = (nse == -1) ? (long) arr[i] * (i+1) : (long)dp[nse] + (i- nse) * arr[i];
            dp[i] %= MOD;
            st.add(i);
        }
        long ans = 0;
        for(int i = 0; i < n; i++){
            ans = (ans + dp[i]) % MOD;
        }
        return (int)ans;
    }
}
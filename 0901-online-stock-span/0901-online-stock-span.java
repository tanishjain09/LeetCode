class StockSpanner {
    Stack<int[]> st;
    int ind;
    public StockSpanner() {
        this.st = new Stack<int[]>();
        this.ind = -1;
    }
    
    public int next(int price) {
        ind += 1;
        while(!st.isEmpty() && st.peek()[0] <= price){
            st.pop();
        }
        int ans = ind - (st.isEmpty() ? -1 : st.peek()[1]);
        st.push(new int[]{price, ind});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
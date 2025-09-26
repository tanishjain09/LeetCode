class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<String> st = new Stack<>();
        for (String node : nodes) {
            st.push(node);
            while (st.size() >= 3 &&
                    st.get(st.size() - 1).equals("#") &&
                    st.get(st.size() - 2).equals("#") &&
                    !st.get(st.size() - 3).equals("#")) {
                st.pop();
                st.pop();
                st.pop();
                st.push("#");
            }
        }
        return st.size() == 1 && st.peek().equals("#");
    }
}

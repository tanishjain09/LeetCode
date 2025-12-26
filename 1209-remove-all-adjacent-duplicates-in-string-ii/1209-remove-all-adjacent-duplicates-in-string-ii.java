class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        int cnt = 0;
        Stack<int[]> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && st.peek()[0] == ch){
                st.peek()[1]++;

                if(st.peek()[1] == k){
                    st.pop();
                }
            }else{
                st.push(new int[]{ch, 1});
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int[] pair : st){
           for(int i = 0; i < pair[1]; i++){
                sb.append((char)pair[0]);
           }
        }
        return sb.toString();
    }
}
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] used = new boolean[26];
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        for(char c : s.toCharArray()){
            freq[c-'a']--;
            if(used[c-'a']) continue;
            while(!st.isEmpty() && st.peek() > c && freq[st.peek()-'a'] > 0){
                used[st.pop()-'a'] = false;
            }
            st.push(c);
            used[c-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
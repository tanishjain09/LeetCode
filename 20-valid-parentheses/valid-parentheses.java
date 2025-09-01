class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char st : s.toCharArray()){
            if(st == '(' || st == '{' || st == '['){
                stack.push(st);
            }else{
                if(stack.isEmpty()) return false;
                char ch = stack.pop();
                if( (st == '}' && ch == '{') || (st == ')' && ch == '(') || (st == ']' && ch == '[')) continue;
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
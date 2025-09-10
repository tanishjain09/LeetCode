class Solution {
    public int minInsertions(String s) {
        int res = 0;
        int need = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                need += 2;
                if(need%2==1){
                    need--;
                    res++;
                }
            }else{
                need--;
                if(need < 0){
                    need = 1;
                    res++;
                }
            }
        }
        return need + res;
    }
}
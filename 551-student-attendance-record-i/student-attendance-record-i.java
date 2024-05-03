class Solution {
    public boolean checkRecord(String s) {
          
        int n  = s.length();
        int abs = 0;
        int leave = 1;
        int maxleave=1;
        for(int i = 0; i<n; i++){
            char myval = s.charAt(i);
            if(myval == 'A'){
                abs++;
            }
        }

        for(int i=0; i<n-1; i++){
            char curr = s.charAt(i);
            char next = s.charAt(i+1);
            

            if(curr == next && next == 'L' ){
                leave++;
                if(leave>maxleave){
                maxleave++;
                }
            }
            else{
                leave= 1;
            }
         }

        if(abs >= 2 || maxleave >= 3){
            return false;
        }
            return true;
    }
}
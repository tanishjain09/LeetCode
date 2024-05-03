class Solution {
    public int alternateDigitSum(int n) {
        String s = Integer.toString(n);
        int last = s.length();
        int evensum = 0;
        int oddsum = 0;

        for(int i = 0; i<last; i++){
            int curr = s.charAt(i) - 48;
            if(i % 2 == 0){
                evensum += curr;
            }else{
                oddsum += curr;
            }
        }


       return evensum - oddsum;
    }
}
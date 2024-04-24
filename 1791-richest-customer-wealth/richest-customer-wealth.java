class Solution {
    public int maximumWealth(int[][] accounts) {
             int uni = 0;
            for(int i=0; i<accounts.length; i++){
                int temp = 0;
            
                for(int j=0; j<accounts[i].length; j++){
                    temp += accounts[i][j];  
                }
                if(temp>uni)
                {
                    uni = temp;

                }
            }
            return uni;
}
}
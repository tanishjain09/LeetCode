class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int slot = 1;
        for(String s: nodes){
            if(slot <= 0) return false;
            if(s.equals("#")){
                slot -= 1;
            }else{
                slot += 1;
            }
        }
        return slot==0?true:false;
    }
}
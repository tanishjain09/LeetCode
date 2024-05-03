class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for(String value: word1){
            s1.append(value);
        }
        for(String value: word2){
            s2.append(value);
        }
        if(s1.toString().equals(s2.toString())){
            return true;
        }
        return false;

    }
}
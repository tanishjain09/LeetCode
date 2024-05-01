class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
       StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        

        String temp1 = Arrays.toString(word1);
        String clean_1 = temp1.replace("[", "");
        String clean_2 = clean_1.replace("]", "");
        String clean_3 = clean_2.replace(" ", "");
        String clean_final = clean_3.replace(",", "");
        sb1.append(clean_final);

        String temp2 = Arrays.toString(word2);
        String tclean_1 = temp2.replace("[", "");
        String tclean_2 = tclean_1.replace("]", "");
        String tclean_3 = tclean_2.replace(" ", "");
        String tclean_final = tclean_3.replace(",", "");
        sb2.append(tclean_final);

            if(sb1.toString().equals(sb2.toString())){
                return true;
            }
            return false; 
    }
}
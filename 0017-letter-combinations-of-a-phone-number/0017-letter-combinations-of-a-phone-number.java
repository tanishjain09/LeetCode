class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        letterCombinations(0, digits, new StringBuilder(), res, map);
        return res;
    }
    private void letterCombinations(int index, String s, StringBuilder comb, List<String> res, Map<Character, String> map){
        if(index == s.length()){
            res.add(comb.toString());
            return;
        }
        String letters = map.get(s.charAt(index));
        for(char letter: letters.toCharArray()){
            comb.append(letter);
            letterCombinations(index+1,s,comb,res,map);
            comb.deleteCharAt(comb.length()-1);
        }
    }
}
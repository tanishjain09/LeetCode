class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();

        if(s.length() != t.length()) return false;

        for(int i = 0; i < s.length(); i++){
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            countS.put(chS, countS.getOrDefault(chS, 0) + 1);
            countT.put(chT, countT.getOrDefault(chT, 0) + 1);
        }

        return countS.equals(countT);
    }
}
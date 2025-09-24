class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : text.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int countB = map.getOrDefault('b', 0);
        int countA = map.getOrDefault('a', 0);
        int countL = map.getOrDefault('l', 0) / 2;
        int countO = map.getOrDefault('o', 0) / 2;
        int countN = map.getOrDefault('n', 0);

        return Math.min(Math.min(Math.min(Math.min(countB,countA),countL),countO),countN);
    }
}
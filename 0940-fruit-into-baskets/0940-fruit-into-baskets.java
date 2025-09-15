class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0, r = 0, maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(r < fruits.length){
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while(map.size() > 2){
                map.put(fruits[l], map.getOrDefault( fruits[l], 0) - 1);
                if(map.get(fruits[l]) == 0) map.remove(fruits[l]);
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}
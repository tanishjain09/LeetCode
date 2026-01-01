class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> rankMap = new HashMap<>();

        int rank = 1;
        for(int i = 0; i < n; i++){
            if(!rankMap.containsKey(sortedArr[i])){
                rankMap.put(sortedArr[i], rank);
                rank++;
            }
        }
        for(int i = 0; i< n; i++){
            sortedArr[i] = rankMap.get(arr[i]);
        }
        return sortedArr;

    }
}
class Solution {
    public int findDuplicate(int[] arr) {
        boolean[] seen = new boolean[arr.length +1];
        for(int num : arr){
            if(seen[num]) return num;
            seen[num] = true;
        }
        return -1;
    }
}
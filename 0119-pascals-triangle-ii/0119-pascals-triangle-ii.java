class Solution {
    public List<Integer> getRow(int rowIndex) {
        long val = 1;
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for(int i = 1; i <= rowIndex; i++){
            val = val*(rowIndex-i+1)/i;
            ans.add((int)val);
        }
        return ans;
    }
}
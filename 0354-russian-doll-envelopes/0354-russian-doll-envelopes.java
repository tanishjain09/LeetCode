class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0]==b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        List<Integer> temp = new ArrayList<>();
        temp.add(envelopes[0][1]);
        for(int[] envelope: envelopes){
            if(envelope[1] > temp.get(temp.size()-1)){
                temp.add(envelope[1]);
            }
            else{
                int index = lowerBound(temp, envelope[1]);
                temp.set(index, envelope[1]);
            }
        }
        return temp.size();
    }
    private int lowerBound(List<Integer> temp, int target){
        int left = 0, right = temp.size()-1;
        while(left <= right){
            int mid = (int)Math.floor((left + right) / 2);
            if(temp.get(mid) < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}
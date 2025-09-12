class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int n = intervals.length;
        int lastEndTime = intervals[0][1];
        int count = 1;
        for(int i = 1; i < n; i++){
            if(intervals[i][0] >= lastEndTime){
                count++;
                lastEndTime = intervals[i][1];
            }
        }
        return n - count;
    }
}
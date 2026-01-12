class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for(int i = 1; i < points.length; i++){
            int preX = points[i-1][0];
            int preY = points[i-1][1];
            int x = points[i][0];
            int y = points[i][1];
            int sum = Math.max( Math.abs(x-preX), Math.abs(y-preY));
            ans += sum;
        }
        return ans;
    }
}
class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a,b) -> a[0]-b[0]);
        int count = 0;
        int[][] dp = new int[n][3];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(events, 0, count, n, dp);
    }
    private int solve(int[][] events, int i, int count, int n, int[][] dp){
        if(count == 2 || i == n){
            return 0;
        }
        if(dp[i][count] != -1) return dp[i][count];
        int validIndex = binarySearch(events, events[i][1], n);
        int take = events[i][2] + solve(events, validIndex, count+1, n, dp);
        int notTake = solve(events, i+1, count, n, dp);
        return dp[i][count] = Math.max(take, notTake);
    }
    private int binarySearch(int[][] events, int endTime, int n){
        int l = 0;
        int r = n-1;
        int ans = n;
        while(l <= r){
            int mid = l + (r-l) / 2;
            if(events[mid][0] > endTime){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}
class Solution {
    public int maxHeight(int[][] cuboids) {
        //first sort all dimenstions for every cuboid
        for(int[] row : cuboids){
            Arrays.sort(row);
        }
        //second sort all cuboids
        Arrays.sort(cuboids, (a,b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        //lis logic
        int n = cuboids.length;
        int[] dp = new int[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            dp[i] = cuboids[i][2];
            for(int j = 0; j < i; j++){
                if(cuboids[i][0] >= cuboids[j][0] &&
                    cuboids[i][1] >= cuboids[j][1] &&
                    cuboids[i][2] >= cuboids[j][2]){
                        dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                    }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
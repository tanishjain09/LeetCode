class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int[] it : edges){
                int u = it[0];
                int v = it[1];
                int wt = it[2];

                dist[u][v] = wt;
                dist[v][u] = wt;
            }
        }
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        int cityNo = -1;
        int cityCnt = n;
        for(int city = 0; city < n; city++){
            int count=0;
            for(int adjCity = 0; adjCity < n; adjCity++){
                if(dist[city][adjCity] <=  distanceThreshold){
                    count++;
                }
            }
            if(count <= cityCnt){
                cityCnt = count;
                cityNo = city;
            }
        }
        return cityNo;
    }
}
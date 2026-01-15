class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxConsHBars = 1;
        int maxConsVBars = 1;

        int currConsHBars = 1;
        for(int i = 1; i < hBars.length; i++){
            if(hBars[i]-hBars[i-1] == 1){
                currConsHBars++;
            }else{
                currConsHBars = 1;
            }
            maxConsHBars = Math.max(maxConsHBars, currConsHBars);
        }

        int currConsVBars = 1;
        for(int i = 1; i < vBars.length; i++){
            if(vBars[i]-vBars[i-1]==1){
                currConsVBars++;
            }else{
                currConsVBars = 1;
            }
            maxConsVBars = Math.max(maxConsVBars, currConsVBars);
        }
        int side = Math.min(maxConsVBars, maxConsHBars) + 1;
        return side*side;
    }
}
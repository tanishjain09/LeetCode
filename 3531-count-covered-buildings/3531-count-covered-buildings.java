class Pair{
    int min;
    int max;
    public Pair(int min, int max){
        this.min = min;
        this.max = max;
    }
}

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        
        HashMap<Integer, Pair> xToMinMaxY = new HashMap<>();
        HashMap<Integer, Pair> yToMinMaxX = new HashMap<>();

        for(int[] b : buildings){
            int x = b[0];
            int y = b[1];

            
            xToMinMaxY.putIfAbsent(x, new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE));
            xToMinMaxY.get(x).min = Math.min(xToMinMaxY.get(x).min, y);
            xToMinMaxY.get(x).max = Math.max(xToMinMaxY.get(x).max, y);

            yToMinMaxX.putIfAbsent(y, new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE));
            yToMinMaxX.get(y).min = Math.min(yToMinMaxX.get(y).min, x);
            yToMinMaxX.get(y).max = Math.max(yToMinMaxX.get(y).max, x);
        }

        int result= 0;
        for(int[] b : buildings){
            int x = b[0];
            int y = b[1];

            Pair px = yToMinMaxX.get(y);  
            Pair py = xToMinMaxY.get(x);
            if(x > px.min && x < px.max && y > py.min && y < py.max){
                result++;
            }
        }
        return result;
    }
}

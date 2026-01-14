class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = -Double.MAX_VALUE;
        double total = 0.0;
        for(int[] sq : squares){
            double y = sq[1];
            double l = sq[2];
            total += l * l;
            low = Math.min(low, y);
            high = Math.max(high, l + y);
        }

        double resultY = 0.0;
        while(high - low > 1e-5){
            double midY = low + (high - low) / 2.0;
            resultY = midY;
            if(check(squares, midY, total)){
                high = midY;
            }else{
                low = midY;
            }
        }
        return resultY;
    }
    private boolean check(int[][] squares, double midY, double total){
        double botArea = 0.0;
        for(int[] sq : squares){
            double y = sq[1];
            double l = sq[2];

            double botY = y;
            double topY = y+l;

            if(midY >= topY){
                botArea += l*l;
            }else if(midY >= botY){
                botArea += (midY - botY) * l;     
            }
        }
        return botArea >= total / 2.0;
    }
}
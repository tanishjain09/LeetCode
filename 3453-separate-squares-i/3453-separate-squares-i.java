class Solution {
    public double separateSquares(int[][] squares) {
        double minY = getMin(squares);
        double maxY = getMax(squares);
        double precision = 1e-5;
        while(maxY- minY > precision){
            double midY = (minY + maxY) / 2;
            if(isLower(squares, midY)){
                maxY = midY;
            }else{
                minY = midY;
            }
        }
        return minY;
    }
    private double getMin(int[][] squares){
        double minY = squares[0][1];
        for(int[] square : squares){
            minY = Math.min(minY, square[1]);
        }
        return minY;
    }
    private double getMax(int[][] squares){
        double maxY = squares[0][1] + squares[0][2];
        for(int[] square : squares){
            maxY = Math.max(maxY, (square[1] + square[2]));
        }
        return maxY;
    }
    boolean isLower(int[][] squares, double midY){
        double LA = 0, UA = 0;
        for(int[] square : squares){
            double bottomY = square[1];
            double side = square[2];
            double topY = bottomY + side;
            if(topY <= midY){
                LA += side*side;
            }else if(bottomY >= midY){
                UA += side * side;
            }else{
                double below = midY - bottomY;
                double above = topY - midY;
                LA += below * side;
                UA += above * side;
            }
        }
        return LA >= UA;
    }
}
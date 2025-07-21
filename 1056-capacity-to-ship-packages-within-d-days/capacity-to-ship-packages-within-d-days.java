class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max = 0;
        for(int weight: weights){
            min = Math.max(weight, min);
            max += weight;
        }

        int low = min;
        int high = max;

        while(low <= high){
            int mid = (low + high) / 2;

            if(countDay(weights, mid) <= days){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    private int countDay(int[] weights, int maxCap){
        int days = 1;
        int cap = 0;

        for(int i = 0; i < weights.length; i++){
            if(cap + weights[i] > maxCap){
                days = days + 1;
                cap = weights[i];
            }else{
                cap += weights[i];
            }
        }
        return days;
    }
}
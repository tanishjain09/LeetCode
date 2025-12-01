class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] arr = new int[n];
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = intervals[i][0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(arr[i], i);
        }
        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            int val = bs(arr, intervals[i][1]);
            if(val == -1) ans[i] = -1;
            else ans[i] = map.get(arr[val]);

        }
        return ans;
    }

    private int bs(int[] arr, int x){
        int ans = -1;
        int l = 0;
        int r = arr.length-1;

        while(l <= r){
            int mid = l + (r - l) / 2;
            if(arr[mid] == x){
                return mid; 
            }else if(arr[mid] > x){
                ans = mid;
                r = mid -1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
}
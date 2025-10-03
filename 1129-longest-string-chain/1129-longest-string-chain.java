class Solution {
    public int longestStrChain(String[] arr) {
        Arrays.sort(arr, (s1, s2) -> s1.length() - s2.length());
        int n = arr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if (compare(arr[i], arr[j]) && dp[j] + 1 > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }
            if(maxi< dp[i]){
                maxi = dp[i];
            }
        }
        return maxi;
    }

    boolean compare(String s1, String s2){
        if(s1.length() != s2.length() + 1)return false;
        int first = 0;
        int second  = 0;

        while(first < s1.length()){
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }
        return first == s1.length() && second == s2.length();
    }
}
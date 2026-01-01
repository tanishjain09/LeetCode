class Solution {
    public int[] plusOne(int[] arr) {
        reverse(arr);
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        int carry = 1;
        for(int i = 0; i < n; i++){
            int sum = arr[i] + carry;
            if(sum == 10){
                list.add(sum%10);
                continue;
            }
            list.add(sum);
            carry = 0;
        }
        if(carry == 1){
            list.add(carry);
        }
        Collections.reverse(list);
        int[] ans = new int[list.size()];
        int i = 0;
        for(int num : list){
            ans[i++] = num;
        }
        return ans;
    }
    private void reverse(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
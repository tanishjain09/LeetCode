class Solution {
    public int[] asteroidCollision(int[] arr) {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] > 0){
                stack.addLast(arr[i]);
            }else{
                while(!stack.isEmpty() && stack.getLast() > 0 &&stack.getLast() < Math.abs(arr[i])){
                    stack.removeLast();
                }
                if(!stack.isEmpty() && stack.getLast() == Math.abs(arr[i])){
                    stack.removeLast();
                }else if(stack.isEmpty() || stack.getLast() < 0){
                    stack.add(arr[i]);
                }
            }
        }
        int[] ans = new int[stack.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = stack.get(i);
        }
        return ans;
    }
}
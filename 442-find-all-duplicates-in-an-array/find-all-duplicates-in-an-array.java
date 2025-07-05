class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        List<Integer> result = new ArrayList<>();
        while(i< nums.length){
            int correct = nums[i] - 1;
            int arrTemp = nums[i];
            if(nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp -1] = temp;
            }else{
                i++;
            }
        }
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != index+1){
                result.add(nums[index]);
            }
        }
        return result;
    }
}
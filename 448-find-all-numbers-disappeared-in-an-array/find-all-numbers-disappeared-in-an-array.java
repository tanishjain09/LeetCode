class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }else {
                i++;
            }
        }
        //just find missing number
        for (int index = 0; index < nums.length; index++) {
            if(nums[index] != index+1){
                result.add(index+1);
            }
        }
        return result;
    }
}
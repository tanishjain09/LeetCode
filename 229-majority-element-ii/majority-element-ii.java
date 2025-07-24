class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int count1 = 0, count2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(count1 == 0 && nums[i] != el2){
                count1 ++;
                el1 = nums[i];
            }
            else if(count2 == 0 && nums[i] != el1){
                count2++;
                el2 = nums[i];
            }
            else if(el1 == nums[i]) count1++;
            else if(el2 == nums[i]) count2 ++;
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0; count2 = 0;

        for (int i = 0; i < nums.length; i++){
            if(el1 == nums[i]) count1++;
            if(el2 == nums[i]) count2++;
        }

        int mini = (int)(nums.length / 3);
        if(count1 > mini) res.add(el1);
        if(count2 > mini) res.add(el2);
        Collections.sort(res);
        return res;
    }
}
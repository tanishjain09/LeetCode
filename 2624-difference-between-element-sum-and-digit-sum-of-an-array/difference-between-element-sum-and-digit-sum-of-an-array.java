class Solution {
    public int differenceOfSum(int[] nums) {
       int n = nums.length;
        int numssum = 0;
        int digitsum = 0;

        for(int i = 0; i<n; i++){
            //for numssum 
            numssum += nums[i];   

            while(nums[i]>0){
                int digit = nums[i]%10;
                digitsum += digit;
                nums[i]/= 10;
            }
       }
       return Math.abs(numssum - digitsum);

    }
}
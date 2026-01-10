class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        int diffBit = xor & (-xor);//find digtinguish bit

        int x = 0, y = 0;
        for(int num : nums){
            if((num & diffBit) == 0){
                x ^= num;
            }else{
                y ^= num;
            }
        }
        return new int[]{x,y};
    }
}
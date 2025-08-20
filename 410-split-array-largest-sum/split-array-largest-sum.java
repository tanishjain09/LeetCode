class Solution {
    public int splitArray(int[] nums, int k) {
        int low = max(nums);
        int high = sum(nums);

        while(low <= high){
            int mid =(low + high)  /2;
            
            int count = countPossibleWays(nums, mid);

            if(count > k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }

    private int countPossibleWays(int[] nums, int max){
        int count = 1;
        int sum = 0;

        for(int num : nums){
            if(sum + num > max){
                sum = num;
                count++;
            }else{
                sum += num;
            }
        }
        return count;
    }

    private int max(int[] nums){
        int max = 0;
        for(int num : nums){
            max = Math.max(num, max);
        }
        return max;
    }
    private int sum(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return sum;
    }
}
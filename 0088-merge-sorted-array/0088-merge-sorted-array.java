class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                arr.add(nums1[i]);
                i++;
            }else if(nums1[i] > nums2[j]){
                arr.add(nums2[j]);
                j++;
            }else{
                arr.add(nums1[i]);
                arr.add(nums2[j]);
                i++;
                j++;
            }
        }
        while(i < m){
            arr.add(nums1[i]);
            i++;
        }
        while(j < n){
            arr.add(nums2[j]);
            j++;
        }
        int k = 0;
        for(int num : arr){
            nums1[k++] = num;
        }
    }
}
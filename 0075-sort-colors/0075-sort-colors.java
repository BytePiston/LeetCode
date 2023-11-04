class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int m = 0;
        int r = nums.length-1;
        while(m<=r) {
            if(nums[m]==0){
                swap (nums, m, l);
                m++;
                l++;
            } else if(nums[m]==1){
                m++;
            }else {
                swap (nums, m, r);
                r--;
            }
        }
    }

    void swap (int[] nums, int m, int l){
        int temp = nums[m];
        nums[m] = nums[l];
        nums[l] = temp;
    }
}
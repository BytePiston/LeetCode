class Solution {
    public void nextPermutation(int[] nums) {
        int peak = findPeak(nums);
        if(peak == 0){
            Arrays.sort(nums);
        } else{
            int i = peak;
            for(int k=i; k<nums.length; k++){
                if(nums[k]>nums[peak-1] && nums[k]<nums[i])
                    i = k;
            }
            swap(nums, i, peak-1);
            Arrays.sort(nums, peak, nums.length);
        }   
    }

    int findPeak(int[] nums){
        int peak = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i]>nums[i-1])
                peak = i;
        }
        return peak;
    }

    void swap(int[] nums, int i, int k){
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }
}
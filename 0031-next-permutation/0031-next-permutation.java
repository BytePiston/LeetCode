class Solution {
    public void nextPermutation(int[] nums) {
        int peak = findPeak(nums);
        if(peak == 0){
            reverseArray(nums);
        } else{
            int k = peak;
            for(int i=peak; i<nums.length; i++){
                if(nums[i]>nums[peak-1] && nums[i]<nums[k]){
                    k=i;
                }
            }
            swap(nums, peak-1, k);
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
    
    int[] reverseArray(int[] nums){
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            swap(nums, left, right);
            left++;
            right--;
        }
        return nums;
    }
    
    void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
class Solution {
    public int findPeakElement(int[] nums) {
       return findPeakNative(nums);
    }
    
    //  Iterative Native Solution where peak var is first set to 0 and for each element in the array if we find any element greater or equal to element at peak index;
    int findPeakNative(int[] nums){
        int peak = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] >= nums[peak]){
                peak = i;
            }
        }
        return peak;
    }
}
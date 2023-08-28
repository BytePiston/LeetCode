class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0)
            return -1;
        else if(nums.length == 1 || nums[0]<nums[nums.length-1])
            return nums[0];
        return nums[findPivot(nums)+1];
    }

    int findPivot(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start+1)/2;
           if(mid < end && nums[mid]>nums[mid+1])
                return mid;
            else if(mid < end && nums[mid]<nums[mid-1])
                return mid-1;
            else if(nums[start] <= nums[mid])
                start = mid+1;
            else if(nums[start] >= nums[mid])
                end = mid-1;        
        }
        return end;
    }  
}
class Solution {
    public int findPeakElement(int[] nums) {
    //  return findPeakNative(nums);    //  O(N) time complexity;
        return findPeakBinarySearch(nums);   //  O(log N) time complexity;
    }
    
    //  Using Binary search technique to indentify Peak elements from given Array;
    int findPeakBinarySearch(int[] nums){
        int low = 0;
        int high = nums.length-1;
        while(low<high){
            int mid = low + (high-low)/2;   //  To find mid element to avoid out of bound issue for large array size;
            if(nums[mid] > nums[mid+1]){    // If mid is greater than next element meaning we have come to far adjust high;
                high = mid;
            }   else if(nums[mid] < nums[mid+1]){    // If mid is lesser than next element meaning we have come to far adjust high;
                low = mid +1;
            }
        }
        return low;
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
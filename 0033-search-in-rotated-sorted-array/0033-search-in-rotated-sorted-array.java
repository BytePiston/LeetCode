class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        if(nums[0] <= nums[nums.length-1]){
            return binarySearch(nums, target, 0, nums.length-1);
        }
        int pivot = findPivot(nums);
        if(nums[pivot] == target){
            return pivot;
        } else if(nums[pivot+1] <= target && nums[nums.length-1] >= target){
            return binarySearch(nums, target, pivot+1, nums.length-1);
        } else{
            return binarySearch(nums, target, 0, pivot-1);
        }
    }
    
    int findPivot(int[] nums){
        int low = 0;
        int high = nums.length-1;
        
        while(low < high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] > nums[high]){
                low = mid + 1;
            } else if(nums[mid] < nums[mid+1]){
                high = mid;
            } else{
                high--;
            }
        }
        
        return low-1;
    }
    
    int binarySearch(int[] nums, int target, int low, int high){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else{
                high = mid-1;
            }
        }
        return -1;
    }
}
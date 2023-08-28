class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = binarySearch(nums, target, true);
        if(result[0] != -1)
            result[1] = binarySearch(nums, target, false);
        return result;
    }

    int binarySearch(int[] nums, int target, boolean isFirstIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end - start+1)/2;
            if(nums[mid] < target){
                start = mid+1;
            } else if(nums[mid] > target){
                end = mid-1;
            }else{
                ans = mid;
                if(isFirstIndex){
                    end = mid -1;
                }else{
                    start = mid+1;
                }
            }
        }
        return ans;
    }
}
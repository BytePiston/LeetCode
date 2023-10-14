class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        if(nums.length == 1)
            return nums[0] == target ? 0 : -1;
        int s = 0;
        int e = nums.length-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid] < target)
                s = mid + 1;
            else if(nums[mid] == target)
                return mid;
            else
                e = mid - 1;
        }
        return -1;
    }
}
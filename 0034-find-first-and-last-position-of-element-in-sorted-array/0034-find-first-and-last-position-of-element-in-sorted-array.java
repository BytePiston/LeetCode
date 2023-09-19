class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        result[0] = search(nums, target, true);
        if(result[0] >= 0){
            result[1] = search(nums, target, false);
        }
        return result;
    }

    int search(int[] nums, int target, boolean isFirst){
        int ans = -1;
        int s = 0;
        int e = nums.length-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target){
                ans = mid;
                if(isFirst)
                    e = mid-1;
                else
                    s = mid+1;
            }
            else if(nums[mid] > target)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return ans;
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        while(s<e){
            int sum = nums[s] + nums[e];
            if(sum == target)
                return new int[]{s+1, e+1};
            else if(sum > target)
                e = search(nums, target-nums[s], s+1, e-1);
            else
                s = search(nums, target-nums[e], s+1, e-1);

        }
        return null;
    }

    int search(int[] nums, int target, int s,  int e){
        int mid = 0;
        while(s<=e){
            mid = s + (e-s)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                s = mid+1;
            else
                e = mid-1;
        }
        return mid;
    }
}
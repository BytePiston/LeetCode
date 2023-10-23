class Solution {
    public int[] twoSum(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        while(s<e){
            int mid = s + (e-s)/2;
            if(nums[s]+nums[e] == target)
                return new int[]{s+1,e+1};
            else if(nums[s]+nums[mid] == target)
                return new int[]{s+1,mid+1};
            else if(nums[mid]+nums[e] == target)
                return new int[]{mid+1,e+1};
            
            if(nums[s]+nums[e] < target)
                s++;
            else if(nums[s]+nums[e] > target)
                e--;
        }
        return new int[]{-1, -1};
    }
}
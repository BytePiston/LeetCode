class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        return Math.max(robHelper(nums, 0, nums.length-1), robHelper(nums, 1, nums.length));
    }
    
    public int robHelper(int[] nums, int low, int high){
        int prev2 = 0;
        int prev = nums[low];
        
        for(int i=low+1; i<high; i++){
            int pick = nums[i] + prev2;
            int notPick = 0 + prev;
            int curr = Math.max(pick, prev);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
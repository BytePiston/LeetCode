class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWaysHelper(nums, target, 0, 0);
    }
    
    int findTargetSumWaysHelper(int[] nums, int target, int index, int sum){
        
        if(target == sum && index == nums.length){
            return 1;
        } else if(index > nums.length-1){
            return 0;
        }
        
        int result = 0;
        result += findTargetSumWaysHelper(nums, target, index+1, sum-nums[index]);
        result += findTargetSumWaysHelper(nums, target, index+1, sum+nums[index]);
    
        return result;   
    }
}
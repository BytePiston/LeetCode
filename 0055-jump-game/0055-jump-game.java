class Solution {
    public boolean canJump(int[] nums) {

        return canJumpHelper(nums, 0, new Boolean[nums.length]);
    }
    
    boolean canJumpHelper(int[] nums, int index, Boolean[] memo){
        if(index>=nums.length-1){
            return true;
        }
        
        if(memo[index] != null){
            return memo[index];
        }
        
        boolean jump = false;
        
        for(int i=index+1; i<=index+nums[index] && i<nums.length; i++){
            jump = jump || canJumpHelper(nums, i, memo);
        }
        
        return memo[index] = jump;
    }
}
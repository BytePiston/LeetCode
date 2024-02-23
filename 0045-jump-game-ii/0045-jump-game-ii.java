class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        // return jumpHelperMemoization(nums, 0, dp);
        return jumpHelperTabulization(nums, dp);
    }
    
    //Iterative Approach with Tabulization
    int jumpHelperTabulization(int[] nums, int[] dp){
        for(int index=nums.length-1; index>=0; index--){
            if(index == nums.length-1){
                dp[index] = 0;
                continue;
            }

            int minJump = 99999;
            for(int i=index+1; i<=index+nums[index] && i <nums.length; i++){
                minJump = Math.min(minJump, dp[i]+1);
            }
            dp[index] = minJump;
        }
        return dp[0];
    }
    
    // Recursive Approach with Memoization
    int jumpHelperMemoization(int[] nums, int index, int[] dp){
        if(index >= nums.length-1){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        int minJump = 99999; 
        
        for(int i=index+1; i<=index+nums[index] && i <nums.length; i++){
            minJump = Math.min(minJump, jumpHelperMemoization(nums, i, dp)+1);
        }
        
        return dp[index] = minJump;    
    }
}
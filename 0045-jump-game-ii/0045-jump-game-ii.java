class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return jumpHelperMemoization(nums, 0, dp);
    }
    
    //Iterative Approach with Tabulization
    int jumpHelperTabulization(int[] nums, int index, Map<Integer, Integer> memo){
        return 0;
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
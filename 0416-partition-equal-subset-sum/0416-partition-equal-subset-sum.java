class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        if(sum % 2  == 1){
            return false;
        } else if(sum % 2  == 0){
            Arrays.sort(nums);
            boolean[][] memo = new boolean[nums.length+1][(sum/2)+1];
            return canPartitionHelperIterative(nums, sum/2, 0, memo);
        }
        return false;
    }
    
    // Iterative Solution using memoization;
    boolean canPartitionHelperIterative(int[] nums, int sum, int index, boolean[][] memo){
        
        for(int i=0; i<memo.length; i++){
            memo[i][0] = true;
        }
        
        for(int i=1; i<memo.length; i++){
            for(int j=0; j<memo[0].length; j++){
                if(nums[i-1]<=j){
                    memo[i][j] = memo[i-1][j-nums[i-1]] || memo[i-1][j] ;
                } else{
                    memo[i][j] = memo[i-1][j];
                }
            }   
        }
        return memo[memo.length-1][memo[0].length-1];
    }
    
    // Recursive Solution using memoization;
    boolean canPartitionHelperRecursive(int[] nums, int sum, int index, Boolean[][] memo){
        if(sum<0 || index>=nums.length){
            return false;
        }
        if(sum == 0){
            return true;
        }
        
        if(memo[index][sum] != null){
            return memo[index][sum];
        }
        
        boolean include = false;
        if(sum >= nums[index]){
            include = canPartitionHelperRecursive(nums, sum-nums[index], index+1, memo);
        }
        boolean exclude = canPartitionHelperRecursive(nums, sum, index+1, memo);
        return memo[index][sum] = include || exclude;
    }
}
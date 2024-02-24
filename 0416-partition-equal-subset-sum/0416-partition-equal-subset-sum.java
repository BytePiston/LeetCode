class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        //If sum is odd we can partition into 2 arrays; hence returing false;
        if(sum%2==1){
            return false;
        }
        Boolean[][] memo = new Boolean[nums.length+1][(sum/2)+1];
        return canPartitionHelper(nums, sum/2, 0, memo);
    }
    
    boolean canPartitionHelper(int[] nums, int sum, int index, Boolean[][] memo){
        if(sum == 0){
            return true;
        }
        
        if(sum<0 || index>nums.length-1){
            return false;
        }
        
        if(memo[index][sum] != null){
            return memo[index][sum];
        }
        
        boolean include = canPartitionHelper(nums, sum-nums[index], index+1, memo);
        boolean exclude = canPartitionHelper(nums, sum, index+1, memo);
        return memo[index][sum] = include || exclude;
    }
}
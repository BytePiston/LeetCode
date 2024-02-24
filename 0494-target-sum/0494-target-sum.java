class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return findTargetSumWaysHelper(nums, target, 0, 0, memo);
    }
    
    //Recursive solution with Memoization;
    int findTargetSumWaysHelper(int[] nums, int target, int index, int sum, Map<String, Integer> memo){
        
        if(target == sum && index == nums.length){
            return 1;
        } else if(index > nums.length-1){
            return 0;
        }
        String key = sum +":"+index;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        int result = 0;
        result += findTargetSumWaysHelper(nums, target, index+1, sum-nums[index], memo);
        result += findTargetSumWaysHelper(nums, target, index+1, sum+nums[index], memo);
        memo.put(key, result);
        return memo.get(key);   
    }
}
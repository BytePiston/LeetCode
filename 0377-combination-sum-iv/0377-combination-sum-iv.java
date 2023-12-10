class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] memo = new int[target+1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return combinationSumHelper(nums, target, memo);
    }
    
    int combinationSumHelper(int[] nums, int target, int[] memo){
        int res = 0;
        if(target < 0){
            return 0;
        }
        if(memo[target] != -1){
            return memo[target];
        }
        if(target == 0){
            return 1;
        } 
        
        for(int num: nums){
            if(num<=target){
                res += combinationSumHelper(nums, target-num, memo);
            } else{
                break;
            }
        }
        memo[target] = res;
        return memo[target];
    }
}
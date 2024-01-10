class Solution {
    public int rob(int[] nums) {
        return robHelper(nums);
    }
    
/*  
    //Using Recursion and Memoization.
    public int robHelper(int[] nums, int index, Map<Integer, Integer> memo){
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        if(index < 0){
            return 0;
        }
        if(index == 0){
            return nums[index];
        }
        int pick = nums[index] + robHelper(nums, index-2, memo);
        int notPick = 0 + robHelper(nums, index-1, memo);
        memo.put(index, Math.max(pick, notPick));
        return memo.get(index);
    }
*/

    //Using Tabulization.
    public int robHelper(int[] nums){
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1; i<nums.length; i++){
            int pick = nums[i] + prev2;
            int notPick = 0 + prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
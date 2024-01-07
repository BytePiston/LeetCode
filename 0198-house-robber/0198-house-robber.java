class Solution {
    public int rob(int[] nums) {
        return robHelper(nums, nums.length-1, new HashMap<>());
    }
    
    public int robHelper(int[] nums, int index, Map<Integer, Integer> memo){
    
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        if(index<0){
            return 0;
        }
        if(index == 0){
            return nums[index];
        }
        int peak = nums[index] + robHelper(nums, index-2, memo);
        int notPeak = 0 + robHelper(nums, index-1, memo);
        memo.put(index, Math.max(peak, notPeak));
        return memo.get(index);
    }
}
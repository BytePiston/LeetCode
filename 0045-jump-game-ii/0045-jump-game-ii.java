class Solution {
    public int jump(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();
        return jumpHelper(nums, 0, memo);
    }
    
    int jumpHelper(int[] nums, int index, Map<Integer, Integer> memo){
        if(index >= nums.length-1){
            return 0;
        }
        
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        
        int minJump = 99999; 
        
        for(int i=index+1; i<=index+nums[index] && i <nums.length; i++){
            minJump = Math.min(minJump, jumpHelper(nums, i, memo)+1);
        }
        memo.put(index, minJump);
        return memo.get(index);    
    }
}
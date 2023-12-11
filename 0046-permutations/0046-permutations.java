class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(result, new ArrayList<>(), new boolean[nums.length], nums);
        return result;
    }
    
    void permuteHelper(List<List<Integer>> result, List<Integer> potentialAnswer, boolean[] memo, int[] nums){
        if(potentialAnswer.size() == nums.length){
            List<Integer> answer = new ArrayList<>(potentialAnswer);
            result.add(answer);
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(!memo[i]){
                memo[i] = true;
                potentialAnswer.add(nums[i]);
                permuteHelper(result, potentialAnswer, memo, nums);
                potentialAnswer.remove(potentialAnswer.size()-1);
                memo[i] = false;
            }
        }
    }
}
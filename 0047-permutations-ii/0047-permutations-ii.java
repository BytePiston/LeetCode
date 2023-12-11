class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        permuteUniqueHelper(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    void permuteUniqueHelper(int[] nums, List<List<Integer>> result, List<Integer> potentialAnswer, boolean[] memo){
        if(potentialAnswer.size() == nums.length){
            List<Integer> answer = new ArrayList<>(potentialAnswer);
            result.add(answer);
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i] == nums[i-1] && !memo[i-1])
                continue;
            if(!memo[i]){
                memo[i] = true;
                potentialAnswer.add(nums[i]);
                permuteUniqueHelper(nums, result, potentialAnswer, memo);
                potentialAnswer.remove(potentialAnswer.size()-1);
                memo[i] = false;
            }
        }
    }
}
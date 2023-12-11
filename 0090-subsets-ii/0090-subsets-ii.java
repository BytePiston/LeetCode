class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupHelper(0, nums, new ArrayList<>(), result);
        return result;
    }
    
    void subsetsWithDupHelper(int index, int[] nums, List<Integer> innerList, List<List<Integer>> result){
        List<Integer> potentialAnswer = new ArrayList<>(innerList);
        result.add(potentialAnswer);
        for(int i=index; i<nums.length; i++){
            if(i != index && nums[i] == nums[i-1]){
                continue;
            }
            potentialAnswer.add(nums[i]);
            subsetsWithDupHelper(i+1, nums, potentialAnswer, result);
            potentialAnswer.remove(potentialAnswer.size()-1);
        }
    }
}
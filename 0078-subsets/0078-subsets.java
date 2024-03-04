class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsHelper(nums, 0, result, new ArrayList<>());
        return result;
    }
    
    void subsetsHelper(int[] nums, int index, List<List<Integer>> result, List<Integer> potentialAnswer){
        if(index == nums.length){
            result.add(new ArrayList<>(potentialAnswer));
            return;
        }
        if(index>nums.length){
            return;
        }
        //pick scenario;
        potentialAnswer.add(nums[index]);
        subsetsHelper(nums, index+1, result, potentialAnswer);
        potentialAnswer.remove(potentialAnswer.size()-1);
        
        //not pick scenario;
        subsetsHelper(nums, index+1, result, potentialAnswer);
    }
}
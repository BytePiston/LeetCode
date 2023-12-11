class Solution {
/* //Iterative    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        if(nums == null || nums.length == 0){
            return result;
        }
        for(int num : nums){
            int sizeOfInnerLists = result.size();
            for(int i=0; i<sizeOfInnerLists; i++){
                List<Integer> newSubsetList = new ArrayList<>(result.get(i));
                newSubsetList.add(num);
                result.add(newSubsetList);
            }
        }
        return result;
    }
*/
    // Recursive
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsHelper(0, nums, new ArrayList<>(), result);
        return result;
    }

    void subsetsHelper(int index, int[] nums, List<Integer> potentialAnswer, List<List<Integer>> result){
        List<Integer> list = new ArrayList<>(potentialAnswer);
        result.add(list);
        for(int i=index; i<nums.length; i++){
            list.add(nums[i]);
            subsetsHelper(i+1, nums, list, result);
            list.remove(list.size()-1);
        }
    } 
}

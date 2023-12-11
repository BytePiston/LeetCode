class Solution {
    
/*  //Using Extra Space for memo to remeber visited indexes and backtrack;    
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
*/
    
    //Using NO Extra Space; We will swap elements in the array to create new permutaions;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(0, result, nums);
        return result;
    }
    
    void permuteHelper(int index, List<List<Integer>> result, int[] nums){
        if(index == nums.length){
            List<Integer> answer = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(answer);
        }
        
        for(int i=index; i<nums.length; i++){
            swap(nums, index, i);
            permuteHelper(index+1, result, nums);
            swap(nums, index, i);
        }
    }
    
    void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
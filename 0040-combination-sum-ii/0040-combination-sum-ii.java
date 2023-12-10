class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    void combinationSumHelper(int index, int[] candidates, int target, List<List<Integer>> result, List<Integer> potentialAnswer){
        if(target == 0){
            List<Integer> list = new ArrayList<>(potentialAnswer);
            result.add(list);
            return;
        }

        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] <= target){
                potentialAnswer.add(candidates[i]);
                combinationSumHelper(i+1, candidates, target-candidates[i], result, potentialAnswer);
                potentialAnswer.remove(potentialAnswer.size()-1);
            } else{
                break;
            }
        }
    }
}
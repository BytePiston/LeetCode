class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(1, k, n, result, new ArrayList<>());
        return result;
    }

    void combinationSumHelper(int index, int k, int target, List<List<Integer>> result, List<Integer> potentialAnswer){
        if(potentialAnswer.size() == k){
            if(target == 0){
                List<Integer> list = new ArrayList<>(potentialAnswer);
                result.add(list);
            }
            return;
        }
        for(int i=index; i<=9; i++){
            if(i<=target){
                potentialAnswer.add(i);
                combinationSumHelper(i+1, k, target-i, result, potentialAnswer);
                potentialAnswer.remove(potentialAnswer.size()-1);
            } else{
                break;
            }
        }
    }
}
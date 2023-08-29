class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 0; i <= target; i++) {
            dp.add(new ArrayList<>());
        }    
        dp.get(0).add(new ArrayList<>()); // Base case: 0 can be achieved with an empty list       
        for (int candidate : candidates) {
            for (int i = candidate; i <= target; i++) {
                for (List<Integer> prevCombination : dp.get(i - candidate)) {
                    List<Integer> newCombination = new ArrayList<>(prevCombination);
                    newCombination.add(candidate);
                    dp.get(i).add(newCombination);
                }
            }
        }
        
        return dp.get(target);
    }

    
}
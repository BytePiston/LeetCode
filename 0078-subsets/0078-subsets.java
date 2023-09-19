class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> emptyList = new ArrayList<>();
        result.add(emptyList);
        
        for(int num: nums){
            int n = result.size();
            for(int i=0; i<n; i++){
                List<Integer> inner = new ArrayList(result.get(i));
                inner.add(num);
                result.add(inner);
            }
        }
        return result;
    }
}
class Solution {
 //Iterative    
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

/*    // Recursive
    public List<List<Integer>> subsets(int[] nums) {
        return subsetsHelper(new ArrayList<>(), Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    List<List<Integer>> subsetsHelper(List<Integer> processed, List<Integer> unProcessed){
        List<List<Integer>> result = new ArrayList<>();
        if(unProcessed.isEmpty()){
            List<Integer> list = new ArrayList<>(processed);
            result.add(list);
            return result;
        }

        List<Integer> processedWithFirstElement = new ArrayList<>(processed);
        processedWithFirstElement.add(unProcessed.get(0));

        List<Integer> unProcessedWithoutFirstElement = new ArrayList<>(unProcessed);
        unProcessedWithoutFirstElement.remove(0);

        List<List<Integer>> processedWithFirst = subsetsHelper(processedWithFirstElement, unProcessedWithoutFirstElement);
        List<List<Integer>> processedWithoutFirst = subsetsHelper(processed, unProcessedWithoutFirstElement);

        processedWithFirst.addAll(processedWithoutFirst);

        return processedWithFirst;
    } */
}

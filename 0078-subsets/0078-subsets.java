class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        outer.add(list);

        for(int num: nums){
            int n = outer.size();
            for(int i=0; i<n; i++){
                List<Integer> list1 = new ArrayList<>(outer.get(i));
                list1.add(num);
                outer.add(list1);
            }
        }
        return outer;
    }
}
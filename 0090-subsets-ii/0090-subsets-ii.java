class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> emptyList = new ArrayList<>();
        outer.add(emptyList);

        int s = 0;
        int e = 0;
        Arrays.sort(nums);

        for(int i=0; i< nums.length; i++){
            s = 0;

            if(i>0 && nums[i] == nums[i-1])
                s = e+1;
            e = outer.size()-1;
            int n = outer.size();

            for(int j=s; j<n; j++){
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(nums[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
}
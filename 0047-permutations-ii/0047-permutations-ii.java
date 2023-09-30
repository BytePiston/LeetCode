class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        Arrays.sort(nums);
        solve(outer, new ArrayList<>(), new boolean[nums.length], nums);
        return outer;
    }

    void solve(List<List<Integer>> outer, List<Integer> inner, boolean[] tab, int[] nums){
        if(inner.size() == nums.length){
            outer.add(new ArrayList<>(inner));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(tab[i] || (i>0 && nums[i] == nums[i-1] && !tab[i-1]))
                continue;
            tab[i] = true;
            inner.add(nums[i]);
            solve(outer, inner, tab, nums);
            inner.remove(inner.size()-1);
            tab[i] = false;
        }
    }
}
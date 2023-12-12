class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        k = k - 1;
        String result = "";
        List<Integer> nums = new ArrayList<>();
        for(int i=1; i<n; i++){
            fact = fact*i;
            nums.add(i);
        }
        nums.add(n);
        while(true){
            result = result + nums.get(k/fact);
            nums.remove(k/fact);
            if(nums.isEmpty()){
                break;
            }
            k = k%fact;
            fact = fact/nums.size();
        }
        return result;
    }
}
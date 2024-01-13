class Solution {
    
    //  Idea is to find compliment of number such that they form zero;
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complimentMap = new HashMap<>();
        int[] res = new int[2];
        for(int i=0; i<nums.length; i++){
            if(complimentMap.containsKey(nums[i])){
                res[0] = complimentMap.get(nums[i]);
                res[1] = i;
                break;
            }else{
                complimentMap.put(target-nums[i], i);
            }
        }
        return res;
    }
}
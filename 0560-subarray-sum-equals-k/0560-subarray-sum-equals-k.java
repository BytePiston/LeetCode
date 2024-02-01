class Solution {
    
/*
    //Using HashMap to store compliments;
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> complimentMap = new HashMap<>();
        complimentMap.put(0,1);
        int sum = 0;
        int result = 0;
        for(int num: nums){
            sum += num;
            if(complimentMap.containsKey(sum - k)){
                result += complimentMap.get(sum - k);
            }
            complimentMap.put(sum, complimentMap.getOrDefault(sum, 0)+1);
        }
        return result;
    }
*/
    
    //Using recurssion;
    public int subarraySum(int[] nums, int k) {
        return subarraySumHelper(nums, k, 0);
    }
    
    int subarraySumHelper(int[] nums, int target, int index){
        if (index == nums.length) {
            return 0;
        }
        int result = 0;
        int sum = 0;
        for (int i = index; i < nums.length; i++) {
            sum += nums[i];
            if (sum == target) {
                result += 1;
            }
        }
        result += subarraySumHelper(nums, target, index + 1);
        return result;
    }
}
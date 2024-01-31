class Solution {
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
}
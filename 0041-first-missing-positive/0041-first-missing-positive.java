class Solution {
    public int firstMissingPositive(int[] nums) {
        // return firstMissingUsingSet(nums);
        return firstMissingUsingCyclicSort(nums);
    }
    
    //Using cyclic sort without extra space;
    int firstMissingUsingCyclicSort(int[] nums){
        cyclicSort(nums);
        for(int i=0; i<nums.length; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
    
    void cyclicSort(int[] nums){
        int i=0;
        while(i<nums.length){
            if(nums[i]>0 && nums[i]<nums.length && nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            } else{
                i++;   
            }
        }
    }
    
    void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;   
    }
    
    //Using extra space;
    int firstMissingUsingSet(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        
        for(int i=1; i<=nums.length; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return nums.length+1;
    }
}
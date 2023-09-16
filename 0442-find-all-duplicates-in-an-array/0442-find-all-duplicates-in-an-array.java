class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        cyclicSort(nums);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != i+1)
                result.add(nums[i]);        
        }
        System.gc();
        return result;
    }
    void cyclicSort(int[] nums){
        int i = 0;
        while(i<nums.length){
            if(nums[i] != nums[nums[i]-1])
                swap(nums, i, nums[i]-1);
            else
                i++;
        }
    }

    void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
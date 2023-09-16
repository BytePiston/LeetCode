class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        cyclicSort(nums);
        
        List<Integer> result = new ArrayList<>();
        for(int i=0; i< nums.length; i++){
            if(i != nums[i]-1)
                result.add(i+1);
        }
        return result;
        
    }

    void cyclicSort(int[] nums){
        int i = 0;
        while(i<nums.length){
            if(nums[i] <= nums.length && nums[i] != nums[nums[i]-1])
                swap(nums, i, nums[i]-1);
            else
                i++;
        }
    }

    void swap( int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
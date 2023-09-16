class Solution {
    public int[] findErrorNums(int[] nums) {
        cyclicSort(nums);
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1){  
                return new int[] {nums[i], i+1};
            }
        }
        return new int[] {-1, -1};
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
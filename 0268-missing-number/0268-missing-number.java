class Solution {
    public int missingNumber(int[] nums) {
        cyclicSort(nums);
        for(int i=0; i<nums.length; i++){
            if(i != nums[i]){
                return i;
            } 
        }
        return nums.length;
    }

    void cyclicSort(int[] nums){
        int i = 0;
        while(i<nums.length){
            if(nums[i]<nums.length && nums[i] != nums[nums[i]]){
                swap(nums, i, nums[i]);
            }else{
                i++;
            }
        }
    }

    void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
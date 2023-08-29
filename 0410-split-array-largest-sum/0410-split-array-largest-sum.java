class Solution {
    public int splitArray(int[] nums, int k) {
        int s = -1;
        int e = 0;
        for(int i=0; i<nums.length;i++){
            s = Math.max(nums[i], s);
            e += nums[i];
        }
        while(s<e){
            int mid = s + (e - s)/2;
            int pieces = findPieces(nums, mid);
            if(pieces <= k){
                e = mid;
            } else{
                s = mid+1;
            }
        }
        return s;
    }

    int findPieces(int[] nums, int mid){
        int count = 1;
        int sum = 0;
        for(int num : nums){
            if(sum + num > mid){
                sum = num; 
                count++;
            }else{
                sum+=num;
            }
        }
        return count;
    }
}
class Solution {
    /* 
    * Time Complexity: O(N)
    * Space Complexity: O(1); Without Extra Space
    */
    public int trap(int[] height) {
        int trappedWater = 0;
        int l = 0;
        int r = height.length-1;
        int leftMax = height[0];
        int rightMax = height[height.length-1];

        while(l<r){
            if(leftMax<=rightMax){
                l++;
                if(height[l] <= leftMax)
                    trappedWater += leftMax - height[l];
                else
                    leftMax = height[l];
            }else{
                r--;
                if(height[r] <= rightMax)
                    trappedWater += rightMax - height[r];
                else
                    rightMax = height[r];
            }
        }
        return trappedWater;
    }
}
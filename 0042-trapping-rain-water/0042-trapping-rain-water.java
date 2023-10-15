class Solution {
    /* 
    * Time Complexity: O(N)
    * Space Complexity: O(1); Without Extra Space
    */
    public int trap(int[] height) {
        int l = 0;
        int r = height.length-1;
        int lMax = height[l];
        int rMax = height[r];
        int trappedWater = 0;
        while(l<r){
            if(lMax <= rMax){
                l++;
                if(height[l]>lMax)
                    lMax = height[l];
                else
                    trappedWater += lMax - height[l];
            }else{
                r--;
                if(height[r]>rMax)
                    rMax = height[r];
                else
                    trappedWater += rMax - height[r];
            }
        }
        return trappedWater;
    }
}
class Solution {
    public int trap(int[] height) {
        int maxL = height[0];
        int maxR = height[height.length-1];
        int l = 0;
        int r = height.length-1;
        int trappedWater = 0;
         while (l < r) {
            if (maxL <= maxR) {
                l++;
                if (height[l] < maxL) {
                    trappedWater += maxL - height[l];
                } else {
                    maxL = height[l];
                }
            } else {
                r--;
                if (height[r] < maxR) {
                    trappedWater += maxR - height[r];
                } else {
                    maxR = height[r];
                }
            }
        }

        return trappedWater;
    }
}
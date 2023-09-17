class Solution {
    /* 
    * Time Complexity: O(N)
    * Space Complexity: O(N); Extra Space
    */
    public int trap(int[] height) {
        int trappedWater = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int[] minLR = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];
        for(int i=1, j=height.length-2; i<height.length; i++, j--){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
            rightMax[j] = Math.max(rightMax[j+1], height[j]);
        }
        for(int i=0; i<height.length; i++){
            minLR[i] = Math.min(leftMax[i], rightMax[i]);
        }
        for(int i=0; i<height.length; i++){
            if(height[i] <= minLR[i])
                trappedWater +=  minLR[i] - height[i];
        }
        return trappedWater;
    }
}
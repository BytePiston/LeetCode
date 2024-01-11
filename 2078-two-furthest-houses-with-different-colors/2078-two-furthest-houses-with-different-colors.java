class Solution {
    public int maxDistance(int[] colors) {
        
        //Set Left at 0 and right at end of Array;
        int left = 0;
        int right = colors.length-1;
        
        //  Check the distance of First house with different color and at furthest distance starting from Last House;
        while(colors[0] == colors[right]){
            right--;
        }
        
        //  Check the distance of Last house with different color and at furthest distance starting from First House;
        while(colors[colors.length-1] == colors[left]){
            left++;
        }
        
        //Return the Max distance based on both left and right value;
        return Math.max(colors.length-1-left, right);
    }
}
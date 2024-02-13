class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int peak = 0;
        
        
        for(int i=0; i<arr.length; i++){
            if(i>0){
                if(arr[i-1]<arr[i] && arr[i+1]<arr[i]){
                    peak = i;
                } 
            }
        }
        return peak;
    }
}
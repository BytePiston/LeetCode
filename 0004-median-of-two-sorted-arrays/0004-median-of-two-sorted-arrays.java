class Solution {
    int index1 = 0;
    int index2 = 0;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int len = nums1.length + nums2.length;
        int mid = (len-1)/2;
        int count = 0;
        while(count<mid){
            getNext(nums1, nums2);
            count++;
        }
        if(len % 2 == 0){
            int num1 =  getNext(nums1, nums2);
            int num2 =  getNext(nums1, nums2);
            return (double) (num1+num2)/2;
        }
        return getNext(nums1, nums2);
    }
    
    int getNext(int[] nums1, int[] nums2){
        int temp = 0;
        if(index1<nums1.length && index2<nums2.length){
            if(nums1[index1]<=nums2[index2]){
                temp = nums1[index1];
                index1++;
            } else{
                temp = nums2[index2];
                index2++;
            }
        } else if(index1<nums1.length){
            temp = nums1[index1];
            index1++;
        } else if(index2<nums2.length){
            temp = nums2[index2];
            index2++;
        }
        return temp;
    }
}
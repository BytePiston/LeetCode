class Solution {
    
    // Native Approch with K rotation; Time Complexity: O(N); Space Complexity: O(N)
    public void rotateNative(int[] nums, int k) {
        
        int n = nums.length;
        k = k%n;
        
        if(n>1){
            Deque<Integer> deque = new LinkedList<>();
            for(int i=0; i<k; i++){
                deque.addFirst(nums[n-i-1]);
            }
            for(int i=0; i<n-k; i++){
                deque.addLast(nums[i]);
            }
            for(int i=0; i<n; i++){
                nums[i] = deque.removeFirst();
            }
        }
    }

    // Optimized Approch; Time Complexity: O(N); Space Complexity: O(1) (In-place Swapping)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverseArray(nums, n-k, n-1);
        reverseArray(nums, 0, n-k-1);
        reverseArray(nums, 0, n-1);
    }
    
    void reverseArray(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
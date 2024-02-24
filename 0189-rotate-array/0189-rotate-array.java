class Solution {
    
    // Native Approch with K rotation; Time Complexity: O(N) with Extra space
    public void rotate(int[] nums, int k) {
        int n  = nums.length;
        if(k>n){
            k = k%n;
        }
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
}
class Solution {
    
    //O(N) time complexity;
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
    
        for(int i=0; i<nums.length; i++){
            
            //Remove all indices from Deque which are out-of-bound from left side of the Array;
            while(!deque.isEmpty() && deque.peekFirst()<=i-k){
                deque.removeFirst();
            }
            
            //Remove all indices from Deque which are out-of-bound from right side of the Array;
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.removeLast();
            }
            
            deque.addLast(i);
            //Window size reached add it to result array;
            if(i>=k-1){
                result[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
    
    //O(N^2) time complexity;
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int start = 0;
        int end = 0;
        int index = 0;
        
        while(end<nums.length){
            if(deque.isEmpty() || (deque.peekFirst()>=nums[end] && deque.peekLast()>=nums[end])){
                deque.addLast(nums[end]);
            } else{
                while(!deque.isEmpty() && deque.peekLast() < nums[end]){
                    deque.removeLast();
                }
                deque.addLast(nums[end]);
            }
            if(end-start+1 == k){
                result[index] = deque.peekFirst();
                index++;
                if(nums[start] == deque.peekFirst()){
                    deque.removeFirst();
                }
                start++;
            }
            end++;
        }
        return result;
    }
}
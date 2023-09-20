class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int poppedIndex=0;
        for(int num : pushed){
            stack.push(num);
            while(!stack.isEmpty() && poppedIndex<popped.length && stack.peek() == popped[poppedIndex]){
                stack.pop();
                poppedIndex++;
            }
        }
        return poppedIndex == popped.length;
    }
}
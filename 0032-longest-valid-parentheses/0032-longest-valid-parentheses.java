class Solution {
    public int longestValidParentheses(String s) {
        
        //  Edge case where empty or Null String is Encountered;
        if(s == null || s.isEmpty()){
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int left = -1;
        
        // For each char of Input String we will verify the last valid Parentheses max length and update it to max;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                //  Insert the position of Opening Parentheses;
                stack.push(i);
            } else{
                //  If ')' char is Found and stack is Empty then update left variable as we have encountered Invlid Parentheses;
                if(stack.isEmpty()){
                    left = i;
                } else{
                    //  Remove last valid Parentheses position from stack;
                    stack.pop();
                    //  After Pop if the Stack becomes empty meaning we have to see the last Left value and update Max;
                    if(stack.isEmpty()){
                        max = Math.max(max, i-left);
                    } else{
                        //  Else we have to see the last value added to stack and update Max;
                        max = Math.max(max, i-stack.peek());
                    }
                }
            }
        }
        
        return max;
    }
}
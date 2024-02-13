class Solution {
    
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        
        //Left to Right; For identifying Right orphan paranthesis;
        for(char ch: s.toCharArray()){
            if(ch =='('){
                left++;
            } else{
               right++; 
            }
            
            if(left == right){
                max = Math.max(max, left*2);
            }
            else if(right > left){
                left = 0;
                right = 0;
            }
        }
        
        left = 0;
        right = 0;
        
        // Right to Left; For identifying Left orphan paranthesis;
        for(int i=s.length()-1; i>=0;i--){
            if(s.charAt(i) =='('){
                left++;
            } else{
               right++; 
            }
            
            if(left == right){
                max = Math.max(max, left*2);
            }
            else if(left > right){
                left = 0;
                right = 0;
            }
        }
        return max;
    }
    
/*
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
*/
}
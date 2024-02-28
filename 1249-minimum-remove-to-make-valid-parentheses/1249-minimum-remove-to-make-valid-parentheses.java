class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            } else if(ch == ')'){
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '('){
                    stack.pop();
                } else{
                    stack.push(i);   
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>(stack);
        for(int i=0; i<s.length(); i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
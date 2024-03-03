class Solution {
    public String decodeString(String s) {
        int index = 0;
        Stack<Character> stack = new Stack<>();
        while(index<s.length()){
            char ch = s.charAt(index);
            if(ch != ']'){
                stack.push(ch);
            } else{
                StringBuffer sb = new StringBuffer();
                while(!stack.isEmpty() && Character.isLetter(stack.peek())){
                    sb.append(stack.pop());
                }
                sb.reverse();
                String str = sb.toString();
                stack.pop();
                
                sb = new StringBuffer();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    sb.append(stack.pop());
                }
                sb.reverse();
                Integer count = Integer.valueOf(sb.toString());
                
                while(count>0){
                    for(char ch1: str.toCharArray()){
                        stack.push(ch1);
                    }
                    count--;
                }
            }
            index++;
        }
        StringBuffer resultSb = new StringBuffer();
        while(!stack.isEmpty()){
            resultSb.append(stack.pop());
        }
        resultSb.reverse();
        return resultSb.toString();
    }
}
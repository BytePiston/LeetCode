class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str: tokens){
            if(str.equals("*") || str.equals("-") || str.equals("+") || str.equals("/"))
                resolve(str, stack);
            else
                stack.push(Integer.parseInt(str));
        }
        return stack.pop();
    }

    void resolve(String op, Stack<Integer> stack){
        int right = stack.pop();
        int left = stack.pop();
        switch(op){
            case "*":
                stack.push(left * right);
                break;
            case "-":
                stack.push(left - right);
                break;
            case "+":
                stack.push(left + right);
                break;
            case "/":
                stack.push(left / right);
                break;
            default:
                break;
        }
    }
}
class Solution {
    public boolean isValid(String s) {
        if(s.length()<2)
            return false;
        char[] stack = new char[s.length()];
        char[] charArray = s.toCharArray();
        int top = -1;
        for(char ch: charArray){
            switch(ch){
                case '(':
                case '{':
                case '[':
                    stack[++top] = ch;
                    break;
                case ')':
                    if(top == -1 || stack[top] != '(')
                        return false;
                    top--;
                    break;
                case '}':
                    if(top == -1 || stack[top] != '{')
                        return false;
                    top--;
                    break;
                case ']':
                    if(top == -1 || stack[top] != '[')
                        return false;
                    top--;
                    break;
            }
        }
        return top==-1;
    }
}
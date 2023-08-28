class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        char[] stack = new char[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            char newCh = s.charAt(i);
            switch (newCh) {
                case '(':
                case '[':
                case '{':
                    stack[++top] = newCh;
                    break;
                case ')':
                    if (top == -1 || stack[top] != '(')
                        return false;
                    top--;
                    break;
                case ']':
                    if (top == -1 || stack[top] != '[')
                        return false;
                    top--;
                    break;
                case '}':
                    if (top == -1 || stack[top] != '{')
                        return false;
                    top--;
                    break;
            }
        }
        return top == -1;
    }
}
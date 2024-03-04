class MyQueue {
    
    Stack<Integer> mainStack;
    Stack<Integer> tempStack;
    public MyQueue() {
        mainStack = new Stack<>(); //Used for Push Operation;
        tempStack = new Stack<>(); //Used for Pop Operation;
    }
    
    //Move all elements from tempStack -> mainStack before pushing new data to mainStack;
    public void push(int x) {
        if(mainStack.isEmpty()){
            while(!tempStack.isEmpty()){
                mainStack.push(tempStack.pop());
            }
        }
        mainStack.push(x);
    }
    
    //Move all elements from mainStack -> tempStack before popping from tempStack;
    public int pop() {
        if(tempStack.isEmpty()){
            while(!mainStack.isEmpty()){
                tempStack.push(mainStack.pop());
            }
        }
        return tempStack.pop();
    }
    
    //Move all elements from mainStack -> tempStack before peeking from tempStack;
    public int peek() {
        if(tempStack.isEmpty()){
            while(!mainStack.isEmpty()){
                tempStack.push(mainStack.pop());
            }
        }
        return tempStack.peek();
    }
    
    public boolean empty() {
        return mainStack.isEmpty() && tempStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
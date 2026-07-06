class MinStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {
    // Need to create an object, here 
       stack = new Stack<>();
       min = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (min.isEmpty() || val <= min.peek()) min.push(val);
    }
    
    public void pop() {
        int top = stack.pop();

        if (top == min.peek()) {
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/*
    - Create a class that can do the following:
    - push, pop, peek => return top of the stack.
    - behaves like a stack but the implmentation is wirtten by us
*/
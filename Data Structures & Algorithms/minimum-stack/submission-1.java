class MinStack {

    private Stack<Integer> inputStack;
    private Stack<Integer> minSoFar;

    public MinStack() {
        inputStack = new Stack<>();
        minSoFar = new Stack<>();   
    }
    
    public void push(int val) {
        inputStack.push(val);
        if(!minSoFar.isEmpty()) {
            minSoFar.push(Integer.min(val, minSoFar.peek()));
        } else {
            minSoFar.push(val);
        }
    }
    
    public void pop() {
        minSoFar.pop();
        inputStack.pop();  
    }
    
    public int top() {
        return inputStack.peek();
    }
    
    public int getMin() {
        return minSoFar.peek();  
    }
}

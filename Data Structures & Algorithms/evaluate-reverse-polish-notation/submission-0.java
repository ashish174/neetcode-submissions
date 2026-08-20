class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> expressionStack = new Stack<>();
        int secondNum;
        int firstNum;
        int result;
        for(String token : tokens) {
            switch(token.trim()) {
                case "/":
                    secondNum = expressionStack.pop();
                    firstNum = expressionStack.pop();
                    result = firstNum/secondNum;
                    expressionStack.push(result);
                    break;
                case "*":
                    secondNum = expressionStack.pop();
                    firstNum = expressionStack.pop();
                    result = firstNum*secondNum;
                    expressionStack.push(result);
                    break;
                case "+":
                    secondNum = expressionStack.pop();
                    firstNum = expressionStack.pop();
                    result = firstNum+secondNum;
                    expressionStack.push(result);
                    break;
                case "-":
                    secondNum = expressionStack.pop();
                    firstNum = expressionStack.pop();
                    result = firstNum-secondNum;
                    expressionStack.push(result);
                    break;
                default:
                    int number = Integer.parseInt(token);
                    expressionStack.push(number);
                    break;
            }
        }
    return expressionStack.pop(); 
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length==0) {
            return new int[0];
        }
        // decreasingTempIndxStack
        Stack<Integer> stack = new Stack<>();
        int[] warmerTemperatureDaysGap = new int[temperatures.length];
        stack.push(0);
        for(int i=1; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                warmerTemperatureDaysGap[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i); 
        }
        // Remainig item dont have warmer days
        while(!stack.isEmpty()){
            warmerTemperatureDaysGap[stack.pop()] = 0;
        }
        return warmerTemperatureDaysGap;
    }
}

class Solution {
    public int maxArea(int[] heights) {
        int leftPtr = 0;
        int rightPtr = heights.length-1;
        int maxVolume = 0;
        int finalLeftPtr = 0;
        int finalRightPtr = 0;
        while(leftPtr<rightPtr) {
            int volume = (rightPtr-leftPtr) * Integer.min(heights[leftPtr], heights[rightPtr]);
            if(volume > maxVolume) {
                maxVolume = volume;
                finalLeftPtr = leftPtr;
                finalRightPtr = rightPtr;
            }
            if(heights[leftPtr] < heights[rightPtr]){
                leftPtr++;
            } else {
                rightPtr--;
            }
        }
        return maxVolume;
    }
}

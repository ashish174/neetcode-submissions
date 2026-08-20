class Solution {
    public int trap(int[] height) {
        int[] prefixMax = new int[height.length];
        int[] suffixMax = new int[height.length];
        int currPrefixMaxSoFar = 0;
        int currSuffixMaxSoFar = 0;
        for(int i=0; i < height.length; i++){
            //populate prefix array with max elem from left side
            prefixMax[i] = currPrefixMaxSoFar;
            currPrefixMaxSoFar = Integer.max(height[i], currPrefixMaxSoFar);

            //populate suffix array with max elem from right side
            suffixMax[(height.length-1)-i] = currSuffixMaxSoFar;
            currSuffixMaxSoFar = Integer.max(height[(height.length-1)-i], currSuffixMaxSoFar);
        }
        int maxWater = 0;
        for(int i=0; i < height.length; i++) {
            int waterAtI = Integer.min(prefixMax[i], suffixMax[i]) - height[i];
            if(waterAtI > 0){
                maxWater+=waterAtI;
            }
        }
        return maxWater;
        
    }
}

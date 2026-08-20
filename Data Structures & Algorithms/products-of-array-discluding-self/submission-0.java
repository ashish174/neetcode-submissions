class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProductWithoutZero=1;
        Set<Integer> zeroPosition = new HashSet<>();
        for(int i =0; i < nums.length; i++) {
            if(nums[i] == 0){
                zeroPosition.add(i);
            } else {
                totalProductWithoutZero = totalProductWithoutZero*nums[i];
            }
            
        }

        int[] productArray = new int[nums.length];
        for(int i =0; i < productArray.length; i++){
            if(zeroPosition.size() >= 2) {
                productArray[i] = 0;
            } else if(zeroPosition.size()==1) {
                if(nums[i]==0) {
                    productArray[i] = totalProductWithoutZero;
                } else {
                    productArray[i] = 0;
                }   
            } else {
                productArray[i] = totalProductWithoutZero/nums[i];
            } 
        }
        return productArray;
    }
}  

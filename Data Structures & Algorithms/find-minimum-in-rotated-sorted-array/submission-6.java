class Solution {
    //[3,4,5,6,1,2]
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        if(nums[left] < nums[right]){
            //sorted array
            return nums[left];
        }
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] < nums[right]){
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return nums[left];

    }
}

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        return binarySearch(nums, target, 0, nums.length-1);
    }

    int binarySearch(int[] nums, int target, int l, int r){
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            } else if (target < nums[mid]){
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }
}

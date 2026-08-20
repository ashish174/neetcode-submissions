class Solution {
    public int search(int[] nums, int target) {
        int k = findpivot(nums);
        if(target>=nums[k] && target<=nums[nums.length-1]){
            return binarySearch(nums, target, k, nums.length-1);
        } else {
            return binarySearch(nums, target, 0, k-1);
        }
    }

    int binarySearch(int[] nums, int target, int l, int r){
        while(l<=r){
            int mid = (l+r)/2;
            if(target < nums[mid]){
                r = mid -1;
            } else if (target > nums[mid]){
                l = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    int findpivot(int[] nums){
        int l=0;
        int r = nums.length-1;
        if(nums[l] < nums[r]){
            return 0;
        }
        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid] < nums[r]){
                r = mid;
            } else{
                l = mid+1;
            }
        }
        return l;
    }
}

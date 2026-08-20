class Solution {
    // O(m/n) + lg(m+n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = m + n;
        int mid1 = (total-1)/2 ;
        int mid2 = total/2;
        int l1=0, l2=0;
        int count = 0, prev =0, curr = 0;

        while(count<=mid2){
            prev = curr;
            if(l1<m && (l2>=n || (nums1[l1] <= nums2[l2]))) {
                curr = nums1[l1++];
            } else {
                curr = nums2[l2++];
            }
            count++; 
        }
        if(total%2==0){
            return (prev+curr)/2.0;
        } else{
            return curr;
        }
    }

}

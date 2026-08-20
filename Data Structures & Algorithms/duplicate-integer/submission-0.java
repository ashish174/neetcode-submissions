class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums) {
            if(!numSet.contains(num)){
                numSet.add(num);
            } else {
                return true;
            }
        }
    return false;
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffForIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(diffForIndex.containsKey(nums[i])) {
                return new int[]{diffForIndex.get(nums[i]), i};
            } else {
                int diff = target - nums[i];
                diffForIndex.put(diff, i);
            }
        }
        return new int[]{-1, -1};
    }
}

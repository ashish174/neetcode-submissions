class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> intSet = new HashSet<>();
        for(int num : nums) {
            intSet.add(num);
        }
        List<Integer> probablyStartingNums = new ArrayList<>();
        int maxLength = 0;
        for(int num : nums) {
            if(!intSet.contains(num-1)){
                int length = 0;
                int nextNum = num;
                while(intSet.contains(nextNum)){
                    length++;
                    nextNum+=1;
                }
                maxLength = Integer.max(maxLength, length);
            }
        }
        return maxLength;
    }
}

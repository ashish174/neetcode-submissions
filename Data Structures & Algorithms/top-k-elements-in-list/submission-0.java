class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for(int num : nums) {
            if(!numCount.containsKey(num)) {
                numCount.put(num, 1);
            } else {
                numCount.put(num, numCount.get(num)+1);
            }
        }

        List<Map.Entry<Integer, Integer>> sortedEntriesByCountDesc = numCount.entrySet().stream()
        .sorted((e1, e2) -> e2.getValue()-e1.getValue())
        .collect(Collectors.toList());

        int[] result = new int[k];
        for(int i=0; i < k; i++) {
            result[i] = sortedEntriesByCountDesc.get(i).getKey();
        }
        return result;
        
    }
}

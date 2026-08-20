class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(((o1,o2) -> o2-o1));
        //create max heap
        for(int stone : stones) {
            maxHeap.add(stone);
        }
        // Perform destroy
        
        while(maxHeap.size() > 1) {
            int firstWeight = maxHeap.poll();
            int secondWeight = maxHeap.poll();
            int remainingWeight = firstWeight - secondWeight;
            if(remainingWeight!=0) {
                maxHeap.add(remainingWeight);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}

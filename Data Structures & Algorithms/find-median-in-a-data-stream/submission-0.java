class MedianFinder {
    Queue<Integer> maxHeap;
    Queue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(((o1,o2) -> o2 - o1));
        minHeap = new PriorityQueue<>();     
    }
    
    public void addNum(int num) {
        if(maxHeap.size() > minHeap.size()) {
            if(maxHeap.size() > 0 && num < maxHeap.peek()) {
                int tmp = maxHeap.poll();
                maxHeap.add(num);
                minHeap.add(tmp);
            } else {
                minHeap.add(num);
            }
        } else {
            if(minHeap.size() > 0 && num > minHeap.peek()){
                int tmp = minHeap.poll();
                maxHeap.add(tmp);
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        }
    }
    
    public double findMedian() {
        return maxHeap.size()==minHeap.size() 
            ? ((maxHeap.peek()+minHeap.peek())/2.0) 
            : maxHeap.peek();

    }
}

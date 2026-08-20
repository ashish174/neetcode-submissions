class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<HeapNode> maxHeap = new PriorityQueue<>(((o1, o2) -> Double.compare(o2.distance, o1.distance)));
        for(int[] point : points) {
            maxHeap.add(new HeapNode(point, Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2))));
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.stream()
                .map(node -> node.point)
                .toArray(int[][]::new);
        

    }

        class HeapNode {
        int[] point;
        double distance;

        public HeapNode(int[] point, double distance) {
            this.point = point;
            this.distance = distance;
        }
    }
}

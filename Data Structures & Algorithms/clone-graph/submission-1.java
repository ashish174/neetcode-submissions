/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }

        // Map to track original node -> cloned node
        Map<Node, Node> cloneMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        // Create clone of the starting node and add to map
        Node clonedRoot = new Node(node.val);
        cloneMap.put(node, clonedRoot);
        queue.add(node);

        // BFS traversal
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            
            // Process all neighbors
            for (Node neighbor : current.neighbors) {
                // If neighbor hasn't been cloned yet, create it
                if (!cloneMap.containsKey(neighbor)) {
                    cloneMap.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                
                // Add the cloned neighbor to the cloned node's neighbor list
                cloneMap.get(current).neighbors.add(cloneMap.get(neighbor));
            }
        }
        
        return clonedRoot;       
    }
}
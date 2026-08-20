/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node node = head;
        Node dummy = new Node(0);
        Node tail = dummy;
        Map<Node, Node> nodeMap = new HashMap<>();
        while(node!=null){
            Node newNode = deepCopy(node);
            //assign tail
            tail.next = newNode;
            tail = tail.next;
            //insert into map
            nodeMap.put(node, newNode);
            //next ptr
            node = node.next;
        }

        Node hd2 = dummy.next;
        while(hd2!=null){
            if(hd2.random!=null){
                hd2.random = nodeMap.get(hd2.random);
            }
            hd2 = hd2.next;
        }
        return dummy.next;
    }

    Node deepCopy(Node node){
        Node newNode = new Node(node.val);
        newNode.random = node.random;
        return newNode;
    }


}

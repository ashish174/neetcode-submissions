/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        //n+1 to account for dummy node as well
        // Move fast pointer n+1 steps ahead (so slow will stand right before the node to remove)
        for(int i=0; i< n+1; i++){
            fast = fast.next;
        }
        // Move both pointers until fast reaches the end
        while(fast!=null){
            fast= fast.next;
            slow=slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;

    }
}

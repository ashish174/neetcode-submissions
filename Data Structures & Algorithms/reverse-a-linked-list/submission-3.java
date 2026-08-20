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
    public ListNode reverseList(ListNode head) {
        ListNode head2 = null;
        while(head!=null){
            ListNode tmp = head2;
            head2 = head;
            head = head.next;
            head2.next = tmp;
        }
        return head2;
        
    }
}

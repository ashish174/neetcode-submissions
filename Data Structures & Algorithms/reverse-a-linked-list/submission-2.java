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
              ListNode reverseListHead = null;
      while(head!=null) {
          ListNode tmp = reverseListHead;
          reverseListHead = head;
          head = head.next;
          reverseListHead.next = tmp;
      }
      return reverseListHead;
        
    }
}

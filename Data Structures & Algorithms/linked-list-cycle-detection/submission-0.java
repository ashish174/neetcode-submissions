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
    public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
      return false;
    }
    ListNode slowPtr = head;
    ListNode fastPtr = head;
    while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;
      if (slowPtr == fastPtr) {
        return true;
      }
    }
    return false;
        
    }
}

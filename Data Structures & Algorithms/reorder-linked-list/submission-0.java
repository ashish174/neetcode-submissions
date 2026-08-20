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
    public void reorderList(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr!=null && fastPtr.next!=null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        //Split into 2 list
        ListNode hd1 = head;
        ListNode hd2 = slowPtr.next;
        slowPtr.next=null;
        //reverse second list
        ListNode reverseHd2 = reverseList(hd2);

        //merge in alternate fasion
        ListNode dummyNode = new ListNode(0);
        ListNode tailNode = dummyNode;
        while(hd1!=null && reverseHd2!=null){
            tailNode.next = hd1;
            hd1 = hd1.next;
            tailNode = tailNode.next;

            tailNode.next = reverseHd2;
            reverseHd2 = reverseHd2.next;
            tailNode = tailNode.next;
        }


        tailNode.next = hd1 != null ? hd1 : reverseHd2;
        head = dummyNode.next;



        
    }

    ListNode reverseList(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode tmp = head.next;
        ListNode newHead = reverseList(head.next);
        tmp.next = head;
        head.next=null;
        return newHead;
    }
}

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
        if (head == null || head.next == null) {
            return head; //if empty or single node, return, bottom of the recursion
        }

        ListNode newHead = reverseList(head.next);
        ListNode nodeTraverser = newHead;
        while (nodeTraverser.next != null) {
            nodeTraverser = nodeTraverser.next;
        }
        nodeTraverser.next = head;
        head.next = null;

        return newHead;
    }
}

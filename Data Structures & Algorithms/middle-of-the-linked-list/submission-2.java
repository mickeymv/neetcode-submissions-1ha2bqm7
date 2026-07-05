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
    public ListNode middleNode(ListNode head) {
        int lengthOfList = 0;

        ListNode node = head;

        while(node!=null) {
            lengthOfList++;
            node = node.next;
        }

        int middleNode = lengthOfList/2;

        int runner =0;

        node = head;

        while(node!=null && runner<middleNode) {
            runner++;
            node=node.next;
        }

        return node;
        
    }
}
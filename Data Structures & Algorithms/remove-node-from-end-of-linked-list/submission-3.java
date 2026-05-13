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
        //traverse the nodes and count their number

        ListNode curr = head;
        int noOfNodes = 0;

        while (curr != null) {
            noOfNodes++;
            curr = curr.next;
        }

        int nodeToRemove = noOfNodes - n + 1; //+1 since we start at "1" for the nodes

        if (nodeToRemove == 1) { //head is being removed 
            return head.next;
        }

        //iterate to the node before the nodeToBeRemoved;

        int i = 1;
        curr = head;

        while(i<nodeToRemove-1) {
            curr = curr.next;
            i++;
        }

        curr.next = curr.next.next;

        return head;
    }
}

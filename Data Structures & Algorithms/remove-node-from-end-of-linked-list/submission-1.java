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
        if (head.next == null && n == 1) {
            return null;
        }

        //traverse the nodes and add them to an array 

        ListNode curr = head;

        List<ListNode> nodes = new ArrayList<>();

        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }

        int indexToRemove = nodes.size() - n;

        if (indexToRemove == 0) { //head is being removed 
            head = head.next;
            return head;
        }

        if (n==1) { //tail is being removed 
            nodes.get(indexToRemove-1).next = null;
            return head;
        }

        nodes.get(indexToRemove-1).next = nodes.get(indexToRemove+1);

        return head;
    }
}

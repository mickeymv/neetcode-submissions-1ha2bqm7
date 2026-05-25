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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int overflow) {

        if (l1==null && l2==null) {
            if (overflow==0) {
                return null;
            } else {
                return new ListNode(overflow);
            }
        }

        ListNode result;

        int remainder = 0;

        if (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + overflow;
                
            if (sum > 9) { //there is overflow, get the 
                overflow = 1;
                remainder = sum - 10;
                result = new ListNode(remainder);
            } else {
                overflow = 0;
                result = new ListNode(sum);
            }

            result.next = addTwoNumbers(l1.next, l2.next, overflow);
        return result;

        }

        if (l1 ==null) {
            int sum = l2.val + overflow;
            if (sum > 9) { //there is overflow, get the remainder
                overflow = 1;
                remainder = sum - 10;
                result = new ListNode(remainder);
            } else {
                overflow = 0;
                result = new ListNode(sum);
            }

            result.next = addTwoNumbers(null, l2.next, overflow);
        } else { //l2==null
            int sum = l1.val + overflow;
            if (sum > 9) { //there is overflow, get the remainder
                overflow = 1;
                remainder = sum - 10;
                result = new ListNode(remainder);
            } else {
                overflow = 0;
                result = new ListNode(sum);
            }

            result.next = addTwoNumbers(null, l1.next, overflow);
        }
        return result;

    }
}

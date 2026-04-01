# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None: # handle null case;
            return None;

        #iterate over the list to get the numbers in an array

        values = [];

        curr = head;

        while curr is not None:
            values.append(curr.val);
            curr = curr.next;

        reversedValues = values[::-1];

        #iterate over the reversed array to get the new llist

        newHead = ListNode(reversedValues[0]);
        prev = newHead;

        for i in range(1,len(reversedValues)):
            newNode = ListNode(reversedValues[i]);
            prev.next = newNode;
            prev = newNode;

        return newHead;

        
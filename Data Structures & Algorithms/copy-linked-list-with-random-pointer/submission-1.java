/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> nodeToCopy = new HashMap<>();

        if (head == null) {
            return null;
        }

        //run through every node and create a copy 
        Node headCopy = new Node(head.val);

        nodeToCopy.put(head, headCopy);

        Node curr = head.next;
        //first pass, create copies of nodes and assign to a 
        //map, without linking 
        while (curr != null) {
            Node copy = new Node(curr.val);
            nodeToCopy.put(curr, copy);
            curr = curr.next;
        }

        //second pass, process all the links 
        curr = head;
        while (curr!=null) {
            Node currCopy = nodeToCopy.get(curr);
            currCopy.next = nodeToCopy.get(curr.next);
            currCopy.random = nodeToCopy.get(curr.random);
            curr = curr.next;
        }

        return headCopy;
    }
}

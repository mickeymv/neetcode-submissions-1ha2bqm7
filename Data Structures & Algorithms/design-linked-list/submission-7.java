class Node {
    int val;
    Node right;
    Node left;
    
    public Node() {}

    public Node(int val) {
        this.val = val;
        right = null;
        left = null;
    }
}

class MyLinkedList {
    Node head, tail;
    public MyLinkedList() {
        head = new Node();
        tail = new Node();
        head.right = tail;
        tail.left = head;
    }
    
    public int get(int index) {
        if (index < 0) {
            return -1;
        }

        int currentIndex = 0;
        Node currNode = head.right;

        while (currNode != tail && currentIndex < index) {
            currNode = currNode.right;
            currentIndex++;
        }

        if (currentIndex==index && currNode != tail) {
            return currNode.val;
        }

        return -1; //exceeded the length of the list
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.right = head.right;
        node.left = head;
        head.right = node;
        node.right.left = node;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        node.right = tail;
        node.left = tail.left;
        tail.left = node;
        node.left.right = node;
    }
    
    public void addAtIndex(int index, int val) {
        int currentIndex = 0;
        Node currNode = head.right;
        Node prev = head;
        while (currNode != tail && currentIndex < index) {
            prev = currNode;
            currNode = currNode.right;
            currentIndex++;
        }

        if (currentIndex==index) {
            Node node = new Node(val);
            prev.right = node;
            currNode.left = node;
            node.left = prev;
            node.right = currNode;
        }
    }
    
    public void deleteAtIndex(int index) {
        int currentIndex = 0;
        Node currNode = head.right;
        Node prev = head;
        while (currNode != tail && currentIndex < index) {
            prev = currNode;
            currNode = currNode.right;
            currentIndex++;
        }

        if (currentIndex==index && currNode != tail) {
            prev.right = currNode.right;
            currNode.right.left = prev;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
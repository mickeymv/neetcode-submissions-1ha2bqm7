class LinkedList {

    int size;
    Node head;

    private class Node {
        int val;
        Node next;
    }

    public LinkedList() {
        size = 0;
        head = null;
    }

    public int get(int index) {
        if (size == 0 || index >= size || index < 0) {
            return -1;
        } 


        Node node = this.head;
        int value =  node.val;

        int i=0;

        while (i < index) {
            node = node.next;
            if (node != null) {
                value = node.val;
            }
            i++;
        }
        
        return value;
    }

    public void insertHead(int val) {
        Node newHead = new Node();
        newHead.val = val;
        newHead.next = this.head;

        this.head = newHead;
        size++;
    }

    public void insertTail(int val) {
        Node newTail = new Node();
        newTail.val = val;
        newTail.next = null;

        if (this.head == null) {
            head = newTail;
            size++;
            return;
        }

        Node curr = this.head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newTail;

        size++;
    }

    public boolean remove(int index) {
        if (size == 0 || index >= size) {
            return false;
        } 

        if (index == 0) {
            head = head.next;
            size--;
            return true;
        }

        Node curr = this.head;

        for (int i = 0 ; i < index-1; i++) {
            curr = curr.next;
        }

        Node beforeIndex = curr;

        Node indexNode = null;

        if (curr != null) {
            indexNode = curr.next;
        }

        if (indexNode != null && indexNode.next != null) {
            beforeIndex.next = indexNode.next;
        }

        size--;

        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> array = new ArrayList<Integer>();

        if (size == 0) {
            return array;
        }

        Node curr = head;

        for (int i=0; i<size ; i++) {
            array.add(curr.val);
            curr = curr.next;
        }

        return array;
    }
}

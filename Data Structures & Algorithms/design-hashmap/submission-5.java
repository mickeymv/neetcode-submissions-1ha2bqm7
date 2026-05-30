class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}

class MyHashMap {

    Node[] array;
    int hash = 10_000;

    public MyHashMap() {
        array = new Node[hash];
    }
    
    public void put(int key, int value) {
        int index = key % hash;
        Node nodeAtIndex = array[index];
        Node prev = null;
        if (nodeAtIndex != null) {
            //find node with same key 
            while (nodeAtIndex !=null ) {
                if (key == nodeAtIndex.key) {
                    nodeAtIndex.value = value;
                    return;
                } else {
                    prev = nodeAtIndex;
                    nodeAtIndex = nodeAtIndex.next;
                }
            }
            //no node found with same key, create new node 
            Node newNode = new Node(key, value, null);
            prev.next = newNode;
        } else {
            Node newNode = new Node(key, value, null);
            array[index] = newNode;
        }
    }
    
    public int get(int key) {
        int index = key % hash;
        Node nodeAtIndex = array[index];
        if (nodeAtIndex != null) {
            //find node with same key 
            while (nodeAtIndex !=null ) {
                if (key == nodeAtIndex.key) {
                    return nodeAtIndex.value;
                } else {
                    nodeAtIndex = nodeAtIndex.next;
                }
            }
            return -1;//node with same key not found
        } else {
            return -1;
        }
    }
    
    public void remove(int key) {
        int index = key % hash;
        Node nodeAtIndex = array[index];
        Node prev = null;
        if (nodeAtIndex != null) {
            //find node with same key 
            while (nodeAtIndex !=null ) {
                if (key == nodeAtIndex.key) {
                    if (prev!=null) {
                        prev.next = nodeAtIndex.next;
                        return;
                    } else {
                        array[index] = nodeAtIndex.next;
                        return;
                    }
                } else {
                    prev = nodeAtIndex;
                    nodeAtIndex = nodeAtIndex.next;
                }
            }
            //node with same key not found
        } 
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
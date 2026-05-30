class Node {
    int key;
    int val;
    Node next;

    public Node(int key, int val, Node next) {
        this.key=key;
        this.val=val;
        this.next = next;
    }
}

class HashTable {

    Node[] map;
    int size;
    int capacity;

    public HashTable(int capacity) {
        map = new Node[capacity];
        this.capacity=capacity;
    }

    public void insert(int key, int value) {
        int hashIndex = key%capacity;

        if (map[hashIndex] != null) {
            //collision! find corresponding node in linkedlist if available

            Node prev = null;
            Node currNode = map[hashIndex];

            while (currNode != null) {
                if (key==currNode.key) {
                    //Node found! update value 
                    currNode.val = value;
                    return;
                } else {
                    //get next node
                    prev= currNode;
                    currNode = currNode.next;
                }
            }

            //no node found, add to the end of the list 
            Node newNode = new Node(key, value, null);
            prev.next = newNode;
            size++;
        } else {
            Node newNode = new Node(key, value, null);
            map[hashIndex] = newNode;
            size++;
        }
        
        if (size>=(capacity/2)) {
            resize();
        }
    }

    public int get(int key) {
        int hashIndex = key % capacity;
        if (map[hashIndex] != null) {
            //find corresponding node in linkedlist if available

            Node currNode = map[hashIndex];

            while (currNode != null) {
                if (key==currNode.key) {
                    //Node found! return value 
                    return currNode.val;
                } else {
                    //get next node
                    currNode = currNode.next;
                }
            }
            //reached end of the list without finding node 
            return -1;
        } else {
            return -1;
        }
    }

    public boolean remove(int key) {
        int hashIndex = key % capacity;

        if (map[hashIndex] != null) {
            //collision! find corresponding node in linkedlist if available

            Node prev = null;
            Node currNode = map[hashIndex];

            while (currNode != null) {
                if (key==currNode.key) {
                    //Node found! update prev to next 
                    if (prev!=null) {
                        prev.next = currNode.next;
                    } else {
                        map[hashIndex] = currNode.next;
                    }
                    size--;
                    return true;
                } else {
                    //get next node
                    prev= currNode;
                    currNode = currNode.next;
                }
            }

            //no node found, 
            return false;
        } else {
            return false;
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void resize() {
        int newCapacity = capacity*2;
        Node[] newMap = new Node[newCapacity];
        
        for (Node node : map) {
            if (node != null) {
                int newIndex = node.key % newCapacity;

                if (newMap[newIndex] == null) {
                    newMap[newIndex] = new Node(node.key, node.val, null);
                } else {
                    Node newNode = newMap[newIndex];

                    while(newNode.next != null) {
                        newNode = newNode.next;
                    }

                    newNode.next = new Node(node.key, node.val, null);
                }

                node = node.next; //get other nodes in linkedlist
            }
        }

        map = newMap;
        capacity = newCapacity;
    }
}

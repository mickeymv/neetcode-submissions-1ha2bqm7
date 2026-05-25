class Node {
    int key;
    int val;
    Node left;
    Node right;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity = 0;
    HashMap<Integer, Node> map = new HashMap<>();

    Node leastRecentlyUsed, mostRecentlyUsed;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        leastRecentlyUsed = new Node(-1, -1);
        mostRecentlyUsed = new Node(-1, -1);
        leastRecentlyUsed.right = mostRecentlyUsed;
        mostRecentlyUsed.left = leastRecentlyUsed;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {

            Node node = map.get(key);

            //point nodes beside current node to each other
            Node nodeLeft = node.left;
            Node nodeRight = node.right;

            nodeLeft.right = node.right;
            nodeRight.left = node.left;

            //move the node to the mostRecentlyUsed;
            Node earlierMRU = mostRecentlyUsed.left;
            mostRecentlyUsed.left = node;
            node.left = earlierMRU;
            node.right = mostRecentlyUsed;
            earlierMRU.right = node;

            return map.get(key).val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        //check if key exists 
        if (map.containsKey(key)) {
            //key exists, no need to evict
            Node node = map.get(key);
            node.val = value;

            //point nodes beside current node to each other
            Node nodeLeft = node.left;
            Node nodeRight = node.right;

            nodeLeft.right = node.right;
            nodeRight.left = node.left;

            //move the node to the mostRecentlyUsed;
            Node earlierMRU = mostRecentlyUsed.left;
            mostRecentlyUsed.left = node;
            node.left = earlierMRU;
            node.right = mostRecentlyUsed;
            earlierMRU.right = node;

        } else { //key does not exist, check if we need to evict 
            if (map.size()>=capacity) {
                //we need to evict LRU
                Node nodeToBeEvicted = leastRecentlyUsed.right;
                map.remove(nodeToBeEvicted.key);

                leastRecentlyUsed.right = nodeToBeEvicted.right;
                nodeToBeEvicted.right.left = leastRecentlyUsed;
            } 

            Node node = new Node(key, value);
            map.put(key, node);
            //place the node to the mostRecentlyUsed;
            Node earlierMRU = mostRecentlyUsed.left;
            mostRecentlyUsed.left = node;
            node.left = earlierMRU;
            node.right = mostRecentlyUsed;
            earlierMRU.right = node;
        }
    }
}

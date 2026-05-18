/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> originalToClone = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        return cloneNode(node);
    }

    public Node cloneNode(Node node) {
        if (originalToClone.containsKey(node)) {
            //node is already cloned, return the clone
            return originalToClone.get(node);
        } else {
            //node has not been cloned, create clone by recursing through its neighbors 
            Node clonedNode = new Node(node.val);
            originalToClone.put(node, clonedNode);
            for(Node neighbor : node.neighbors) {
                clonedNode.neighbors.add(cloneNode(neighbor));
            }
            return clonedNode;
        }
    }
}
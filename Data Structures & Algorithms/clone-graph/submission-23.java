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

    HashMap<Node, Node> nodeToClone = new HashMap<>();
    HashSet<Node> visiting = new HashSet<>();

    public Node cloneGraph(Node node) {
        return clone(node);
    }

    public Node clone(Node node) {
        if (node==null) {
            return null;
        }

        if(nodeToClone.containsKey(node)) {
            return nodeToClone.get(node);
        }

        Node clone = new Node(node.val);
        nodeToClone.put(node, clone);

        for(Node neighbor:node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }


        return clone;
    }
}
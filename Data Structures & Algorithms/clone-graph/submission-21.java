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

    HashMap<Integer, Node> valToClone = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    HashSet<Integer> visiting = new HashSet<>();
    

    public Node cloneGraph(Node node) {
        if (node==null) {
            return null;
        }

        //we should run dfs on the graph
        //to make sure we don't revisit the parent, we can keep track 
        //of a visiting set 


        //first pass creates all the clones 
        dfs(node);

        visited.clear();

        clone(node);

        return valToClone.get(1);
    }

    public void dfs(Node node) {
        if (visited.contains(node.val) || visiting.contains(node.val)) {
            return;
        }

        Node clone = new Node(node.val);

        valToClone.put(node.val, clone);

        visiting.add(node.val);

        for(Node neighbor:node.neighbors) {
            dfs(neighbor);
        }

        visiting.remove(node.val);
        visited.add(node.val);
    }

    public void clone(Node node) {
        if (visited.contains(node.val) || visiting.contains(node.val)) {
            return;
        }        

        Node clone = valToClone.get(node.val);

        visiting.add(node.val);

        for(Node neighbor:node.neighbors) {
            clone(neighbor);
            Node neighborClone = valToClone.get(neighbor.val);
            clone.neighbors.add(neighborClone);
        }

        visiting.remove(node.val);
        visited.add(node.val);
    }
}
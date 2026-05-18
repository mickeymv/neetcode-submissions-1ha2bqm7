class Solution {
    Map<Integer, List<Integer>> nodeToNeighbors = new HashMap<>();
    Set<Integer> visitedNodes = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        //the core idea being that in a tree, the leaves can't 
        //have more than one connection to its parent nodes, 
        //i.e. there should not be any cycles in the tree 

        //create an adjacency list with the provided edges 
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            nodeToNeighbors.putIfAbsent(node1, new ArrayList());
            nodeToNeighbors.get(node1).add(node2);
            nodeToNeighbors.putIfAbsent(node2, new ArrayList());
            nodeToNeighbors.get(node2).add(node1);
        }

        if (!isValid(0, -1)) {
            return false;
        }
        
        if (visitedNodes.size() == n) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValid(int node, int parent) {
        //negative condition, if node has already been visited 
        if (visitedNodes.contains(node)) {
            return false;
        }
        //positive condition, if node has no neighbors, it is valid 
        if (!nodeToNeighbors.containsKey(node)) {
            visitedNodes.add(node);
            return true;
        }
        //else, recurse into its neighbors 
        visitedNodes.add(node);
        for (int neighbor : nodeToNeighbors.get(node)) {
            //skip parent 
            if (neighbor == parent) {
                continue;
            }
            if (!isValid(neighbor, node)) {
                return false;
            }
        }
        return true;
    }
}

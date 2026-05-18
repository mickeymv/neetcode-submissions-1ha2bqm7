class Solution {
    Map<Integer, List<Integer>> nodeToNeighbors = new HashMap<>();
    HashSet<Integer> visitedNodes = new HashSet<>();

    public int countComponents(int n, int[][] edges) {
        //pre-populate adj list 
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            nodeToNeighbors.putIfAbsent(node1, new ArrayList());
            nodeToNeighbors.get(node1).add(node2);
            nodeToNeighbors.putIfAbsent(node2, new ArrayList());
            nodeToNeighbors.get(node2).add(node1);            
        }

        int connectedComponents = 0;

        for(int node=0; node < n; node++) {
            if (visitedNodes.contains(node)) {
                continue;//node was already visited and counted towards 
                //the components 
            }
            connectedComponents++;
            visitAllNodesInComponent(node);
        }

        return connectedComponents;
    }

    public void visitAllNodesInComponent(int node) {
        //if already visited, skip 
        if (visitedNodes.contains(node)) {
            return;
        }
        //process node and its neighbors 
        visitedNodes.add(node);
        if (nodeToNeighbors.get(node) == null) {
            return;
        }
        for (int neighbor : nodeToNeighbors.get(node)) {
            visitAllNodesInComponent(neighbor);
        }
    }
}

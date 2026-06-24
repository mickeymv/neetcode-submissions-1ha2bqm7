class Solution {

    HashMap<Integer, List<Integer>> nodeToNeighbors = new HashMap<>();
    HashSet<Integer> visit = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        //we run dfs from a node on the graph 
        //if the dfs visits all nodes, then it is a connected graph 
        //if there is a cycle , we return false 
        //a connected graph with no cycles is a valid tree 

        //we first create a map of the nodeToNodes

        for(int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            List<Integer> node1Neighbors = nodeToNeighbors.getOrDefault(node1, new ArrayList<>());
            List<Integer> node2Neighbors = nodeToNeighbors.getOrDefault(node2, new ArrayList<>());
        
            node1Neighbors.add(node2);
            node2Neighbors.add(node1);

            nodeToNeighbors.put(node1, node1Neighbors);
            nodeToNeighbors.put(node2, node2Neighbors);
        }

        if(!dfs(0, -1)) {
            return false;
        } else {
            return visit.size() == n;
        }
        
    }

    public boolean dfs(int node, int parent) {
        if(visit.contains(node)) {
            return false;
        }

        visit.add(node);


        if (nodeToNeighbors.containsKey(node)) {
            for (int neighbor : nodeToNeighbors.get(node)) {
                if (neighbor!=parent) {
                    if(!dfs(neighbor,node)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

class Solution {
    HashMap<Integer, List<Integer>> nodeToNeighbors = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();

    public int[] findRedundantConnection(int[][] edges) {
        //brute force method is to add an edge one by one 
        //to the adjacency list, run dfs on all nodes, and check if a 
        //cycle exists 

        int noOfNodes = edges.length;

        for(int[] edge : edges) {
            nodeToNeighbors.computeIfAbsent(edge[0], k->new ArrayList<>()).add(edge[1]);
            nodeToNeighbors.computeIfAbsent(edge[1], k->new ArrayList<>()).add(edge[0]);
            for(int node=1;node<=noOfNodes;node++) {
                visited.clear();
                if(isCycleExist(node,-1)) {
                    return new int[] {edge[0],edge[1]};
                }
            }
        }

        return null;
    }

    public boolean isCycleExist(int node, int parent) {
        if(visited.contains(node)) {
            return true;
        }

        visited.add(node);
        if(nodeToNeighbors.containsKey(node)) {
            for(int neighbor : nodeToNeighbors.get(node)) {
                if(neighbor!=parent) {
                    if(isCycleExist(neighbor, node)) {
                        return true;
                    }
                }
            }
        }
        visited.remove(node);

        return false;
    }
}

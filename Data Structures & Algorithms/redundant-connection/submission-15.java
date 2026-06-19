class Solution {
    HashMap<Integer, HashSet<Integer>> nodeNodes = new HashMap<>();
    HashSet<Integer> cycle = new HashSet<>();
    
    public int[] findRedundantConnection(int[][] edges) {
        //build adj list 

        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];

            HashSet<Integer> node1Nodes = nodeNodes.getOrDefault(node1, new HashSet<>());
            HashSet<Integer> node2Nodes = nodeNodes.getOrDefault(node2, new HashSet<>());

            node1Nodes.add(node2);
            node2Nodes.add(node1);

            nodeNodes.put(node1, node1Nodes);
            nodeNodes.put(node2, node2Nodes);

            cycle.clear();

            if(cycleDetected(node1,-1)) {
                return edge;
            }
        }

        return null;
    }

    public boolean cycleDetected(int node, int parent) {
        if(cycle.contains(node)){
            return true;
        }

        //visit node's nodes 

        cycle.add(node);
        HashSet<Integer> nodes = nodeNodes.getOrDefault(node, new HashSet<>());

        for (int neighbor : nodes) {
            if (neighbor == parent) {
                continue;
            }

            if (cycleDetected(neighbor, node)) {
                return true;
            }
        }

        cycle.remove(node);

        return false;
    }
}

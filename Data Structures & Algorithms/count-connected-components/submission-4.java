class Solution {

    HashMap<Integer, List<Integer>> nodeToNodes = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();

    public int countComponents(int n, int[][] edges) {
        for(int[] edge : edges) {
            nodeToNodes.computeIfAbsent(edge[0], k->new ArrayList<>()).add(edge[1]);
            nodeToNodes.computeIfAbsent(edge[1], k->new ArrayList<>()).add(edge[0]);
        }

        int connectedComponents = 0;

        for(int node=0;node<n;node++) {
            if(!visited.contains(node)) {
                connectedComponents++;
                visit(node);
            }
        }

        return connectedComponents;
    }

    public void visit(int node) {
        if(visited.contains(node)) {
            return;
        }

        visited.add(node);


        if (nodeToNodes.containsKey(node)) {
            for(int neighbor : nodeToNodes.get(node)) {
                    visit(neighbor);
            }   
        }

    }
}

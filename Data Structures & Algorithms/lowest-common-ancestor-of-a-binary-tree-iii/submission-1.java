/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> pAncestors = new HashSet<>();
        HashSet<Node> qAncestors = new HashSet<>();

        Node pAncestor = p;
        Node qAncestor = q;

        pAncestors.add(pAncestor);
        qAncestors.add(qAncestor);

        while(pAncestor!=null && qAncestor!=null) {
            if(pAncestors.contains(qAncestor)) {
                return qAncestor;
            }

            if(qAncestors.contains(pAncestor)) {
                return pAncestor;
            }

            if(pAncestor.parent != null ) {
                pAncestor = pAncestor.parent;
                pAncestors.add(pAncestor);
            }
            
            if(qAncestor.parent != null ) {
                qAncestor = qAncestor.parent;
                qAncestors.add(qAncestor);
            }
        }
        
        if(pAncestor.parent == null) {
            return pAncestor;
        }

        
            return qAncestor;
         
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //the core idea is that the LCA node will always be either
        //1. to the left of the processing node if p and q are smaller than it 
        //2. to the right of the processing node if p and q are greater than it 
        //3. the node itself if p and q are to the left and right of it.
        return lca(root, p.val, q.val);   
    }

    public TreeNode lca(TreeNode node, int p, int q) {
        int valOfNode = node.val;

        if (valOfNode < p && valOfNode < q) { //p & q are greater, process the right tree
            return lca(node.right, p, q);
        } else if (valOfNode > p && valOfNode > q) { //p & q are smaller, process the left tree
            return lca(node.left, p, q);
        } else { // nodeVal is within p and q, it itself is the lca
            return node;
        }
    }
}

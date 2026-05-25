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
    ArrayList<Integer> rightSides = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        addRightSide(root, 0);
        return rightSides;    
    }

    public void addRightSide(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth == rightSides.size()) {
            rightSides.add(node.val);
        }
        addRightSide(node.right, depth+1);
        addRightSide(node.left, depth+1);
    }
}

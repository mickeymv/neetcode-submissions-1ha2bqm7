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
    int noOfGoodNodes=0;
    public int goodNodes(TreeNode root) {
        checkForGoodNode(root, -101);
        return noOfGoodNodes;
    }

    public void checkForGoodNode(TreeNode node, int maxValueInPath) {
        if (node == null) {
            return;
        }
        
        if (node.val>=maxValueInPath) {
            noOfGoodNodes++;
            maxValueInPath = node.val;
        }

        checkForGoodNode(node.right, maxValueInPath);
        checkForGoodNode(node.left, maxValueInPath);
    }
}

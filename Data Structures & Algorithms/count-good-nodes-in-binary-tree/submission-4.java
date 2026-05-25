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
        return countOfGoodNodes(root, -101);
    }

    public int countOfGoodNodes(TreeNode node, int maxValueInPath) {
        if (node == null) {
            return 0;
        }

        int countOfGoodNodes = 0;

        if (node.val>=maxValueInPath) {
            countOfGoodNodes++;
            maxValueInPath = node.val;
        }

        countOfGoodNodes += countOfGoodNodes(node.right, maxValueInPath);
        countOfGoodNodes += countOfGoodNodes(node.left, maxValueInPath);

        return countOfGoodNodes;
    }
}

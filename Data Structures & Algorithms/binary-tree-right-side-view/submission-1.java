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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> rightSides = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {
            level++;
            int nodesAtLevel = queue.size();
            while (nodesAtLevel>0) {
                TreeNode node = queue.poll();
                if (rightSides.size()<level) {
                    //we don't have a right-side yet, add this val 
                    rightSides.add(node.val);
                }
                if (node.right!=null) queue.add(node.right);
                if (node.left!=null) queue.add(node.left);
                nodesAtLevel--;
            }
        }

        return rightSides;
    }
}

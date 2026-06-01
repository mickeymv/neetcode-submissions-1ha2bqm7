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
        List<Integer> rightVals = new ArrayList<>();

        if (root == null) {
            return rightVals;
        }

        Queue<TreeNode> q = new ArrayDeque<>();

        q.add(root);

        while (!q.isEmpty()) {
            int nodesInLevel = q.size();
            while (nodesInLevel>0) {
                TreeNode node = q.poll();
                nodesInLevel--;

                if (node.left!=null) {
                    q.add(node.left);
                }

                if (node.right!=null) {
                    q.add(node.right);
                }       

                if (nodesInLevel==0) {
                    //this is the rightmost node, add its val to the result 
                    rightVals.add(node.val);
                }         
            }
        }

        return rightVals;
    }
}

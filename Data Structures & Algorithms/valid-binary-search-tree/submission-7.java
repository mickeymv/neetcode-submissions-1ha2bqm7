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
    public boolean isValidBST(TreeNode root) {
        return isValid(root,-1001,1001);
    }

    public boolean isValid(TreeNode root, int lower, int upper) {
    
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null) {
            if (root.left.val >= root.val || root.left.val <= lower || root.left.val >= upper) {
                return false;
            }
        }

        if (root.right != null) {
            if (root.right.val <= root.val || root.right.val <= lower || root.right.val >= upper) {
                return false;
            }
        }

        return isValid(root.left, lower, root.val) && isValid(root.right, root.val, upper);
    }
}

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
    public int kthSmallest(TreeNode root, int k) {
        //the core idea is the an inorder traversal of a bst 
        //will provide a sorted list. we just need to add the 
        //values in order to a list and then the kth value will 
        //be the kth smallest value 

        return getInOrder(root, new ArrayList<>(), k);

    }

    public int getInOrder(TreeNode node, List<Integer> values, int k) {
        if (node.left != null) {
            int val = getInOrder(node.left, values, k);
            if (val != -1) {
                return val;
            }
        }

        values.add(node.val);

        if (values.size() == k) {
            return node.val;
        }

        if (node.right != null) {
            int val =  getInOrder(node.right, values, k);
            if (val != -1) {
                return val;
            }
        }

        return -1;
    }
}

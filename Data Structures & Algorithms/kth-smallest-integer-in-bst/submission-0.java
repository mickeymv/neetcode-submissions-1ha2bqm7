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

        List<Integer> values = getInOrder(root, new ArrayList<>());

        return values.get(k-1); //list is 0-indexed
    }

    public List<Integer> getInOrder(TreeNode node, List<Integer> values) {
        if (node == null) {
            return values;
        }

        if (node.left != null) {
            getInOrder(node.left, values);
        }

        values.add(node.val);

        if (node.right != null) {
            getInOrder(node.right, values);
        }

        return values;
    }
}

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]); //first element in preorder list is the root 
        
        List<Integer> inOrderList = Arrays.stream(inorder).boxed().collect(Collectors.toList());

        int indexOfRootInInOrder = inOrderList.indexOf(preorder[0]);

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, indexOfRootInInOrder+1), Arrays.copyOfRange(inorder, 0, indexOfRootInInOrder));
        root.right = buildTree(Arrays.copyOfRange(preorder, indexOfRootInInOrder+1, preorder.length), Arrays.copyOfRange(inorder, indexOfRootInInOrder+1, inorder.length));
        return root;
    }
}

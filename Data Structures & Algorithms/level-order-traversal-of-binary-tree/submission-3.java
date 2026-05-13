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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        List<List <Integer>> listOfLists = new ArrayList<>();

        if (root !=null) {
        q.add(root);
} else {
 return listOfLists;
}
        while(!q.isEmpty()) {
            List<Integer> numbersInLevel = new ArrayList<>();
            int levelQueueSize = q.size();
            for (int i=0; i<levelQueueSize; i++) {
                TreeNode node = q.remove();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                numbersInLevel.add(node.val);
            }
            
            listOfLists.add(numbersInLevel);
        }

        return listOfLists;
    }
}

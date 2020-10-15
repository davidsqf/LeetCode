// This code is written by davidsqf.
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traverse = new ArrayList<>();
        if (root == null) return traverse;
        if (root.left != null) {
            traverse.addAll(inorderTraversal(root.left));
        }
        traverse.add(root.val);
        if (root.right != null) {
            traverse.addAll(inorderTraversal(root.right));
        }
        return traverse;
    }
}

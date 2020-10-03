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
    public boolean isValidBST(TreeNode root) {
        boolean flag = true;
        if (root == null) return flag;
        if (root.left != null) {
            TreeNode temp_node = root.left;
            while (temp_node.right != null) temp_node = temp_node.right;
            flag = flag && temp_node.val < root.val && isValidBST(root.left);
        }
        if (root.right != null) {
            TreeNode temp_node = root.right;
            while (temp_node.left != null) temp_node = temp_node.left;
            flag = flag && temp_node.val > root.val && isValidBST(root.right);
        }
        return flag;
    }
}
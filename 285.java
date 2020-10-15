/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        int inorder = Integer.MIN_VALUE;
        
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (inorder == p.val) return root;
            inorder = root.val;
            root = root.right;
        }
        return null;
    }
}

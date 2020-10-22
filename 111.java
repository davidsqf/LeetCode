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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return minDepthHelper(root, 1);
    }
    /**
    * returns if the input node is a leaf
    */
    private boolean isLeaf(TreeNode node) {
        // first check if the node is null
        if (node == null) return false;
        return node.left == null && node.right == null;
    }
    private int minDepthHelper(TreeNode root, int depth) {
        if (isLeaf(root)) {
            return depth;
        }
        // now that root is not a leaf, if root == null, then prune this branch
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(minDepthHelper(root.left, depth + 1),
                       minDepthHelper(root.right, depth + 1));
    }
}

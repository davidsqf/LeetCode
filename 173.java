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
class BSTIterator {
    ArrayList<TreeNode> inOrder;
    int index;
    public BSTIterator(TreeNode root) {
        this.inOrder = inOrderTraverse(root);
        this.index = 0;
    }
    
    /** @return the next smallest number */
    public int next() {
        return inOrder.get(index++).val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < inOrder.size();
    }
    
    private ArrayList<TreeNode> inOrderTraverse(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        
        ArrayList<TreeNode> result = inOrderTraverse(root.left);
        result.add(root);
        result.addAll(inOrderTraverse(root.right));
        return result;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

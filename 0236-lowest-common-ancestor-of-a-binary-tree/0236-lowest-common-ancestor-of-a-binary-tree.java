/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base case: If root is null return null
        if (root == null)
            return null;

        // if we find either p or q, return root
        if (root.val == p.val || root.val == q.val)
            return root;

        // Search in the left and right subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are non-null, root is the LCA
        if (left != null && right != null)
            return root;

        // Otherwise, return whichever side is non-null
        return left != null ? left : right;
    }
}
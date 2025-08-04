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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorderList = new ArrayList<>();
        helper(root, postorderList);
        return postorderList;
    }

    public void helper(TreeNode root, List<Integer> postorderList) {
        if (root == null)
            return;

        helper(root.left, postorderList);
        helper(root.right, postorderList);
        postorderList.add(root.val);
    }
}
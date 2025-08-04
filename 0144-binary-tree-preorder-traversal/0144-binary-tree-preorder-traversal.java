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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();
        helper(root, preorderList);
        return preorderList;
    }

    public void helper(TreeNode root, List<Integer> preorderList) {
        if (root == null)
            return;

        preorderList.add(root.val);
        helper(root.left, preorderList);
        helper(root.right, preorderList);
    }
}
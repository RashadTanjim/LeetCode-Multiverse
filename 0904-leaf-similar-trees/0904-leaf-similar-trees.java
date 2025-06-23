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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        helper(list1, root1);
        helper(list2, root2);

        return list1.equals(list2) ? true : false;
    }

    private void helper(List<Integer> list, TreeNode root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;

        } else {
            helper(list, root.left);
            helper(list, root.right);
        }
    }
}
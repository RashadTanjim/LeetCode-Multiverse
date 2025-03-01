/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    int preIndex = 0;
    HashMap<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i); // (key,value) -> (array value, index)
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right)
            return null;

        int rootValue = preorder[preIndex++];
        int inIndex = inMap.get(rootValue);
        TreeNode root = new TreeNode(rootValue);

        root.left = build(preorder, left, inIndex - 1);
        root.right = build(preorder, inIndex + 1, right);

        return root;
    }
}
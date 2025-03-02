
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
import java.util.*;

class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        int totalSum = 0;
        Stack<Map.Entry<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(root, 0));

        while (!stack.isEmpty()) {

            Map.Entry<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int currentSum = pair.getValue() * 10 + node.val;

            if (node.left == null && node.right == null) {
                totalSum += currentSum;
            }

            if (node.right != null) {
                stack.push(new AbstractMap.SimpleEntry<>(node.right, currentSum));
            }
            if (node.left != null) {
                stack.push(new AbstractMap.SimpleEntry<>(node.left, currentSum));
            }
        }

        return totalSum;
    }
}
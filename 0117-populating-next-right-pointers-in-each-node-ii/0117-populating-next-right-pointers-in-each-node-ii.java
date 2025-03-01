/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {  // LinkedList Implementation to achieve Space Complexity O(1)

        Node dummy = new Node(0);
        Node prev = dummy;
        Node curr = root;

        while (curr != null) {

            if (curr.left != null) {
                prev.next = curr.left;
                prev = prev.next;
            }

            if (curr.right != null) {
                prev.next = curr.right;
                prev = prev.next;
            }

            curr = curr.next;
            if (curr == null) {
                curr = dummy.next;
                dummy.next = null;
                prev = dummy;
            }
        }

        return root;
    }
}
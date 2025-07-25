/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        int max = Integer.MIN_VALUE;

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        for (int i = 0; i < list.size() / 2; i++) {
            max = Math.max(max, list.get(i) + list.get(list.size() - i - 1));
        }

        return max;
    }
}
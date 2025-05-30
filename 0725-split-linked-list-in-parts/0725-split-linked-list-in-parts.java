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
    public ListNode[] splitListToParts(ListNode head, int k) {
        List<ListNode> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }

        int n = nodeList.size();
        int width = n / k, extra = n % k;
        ListNode[] result = new ListNode[k];

        int index = 0;
        for (int i = 0; i < k; i++) {
            int partSize = width + (i < extra ? 1 : 0);

            if (partSize == 0) {
                result[i] = null;
                continue;
            }

            result[i] = nodeList.get(index);
            for (int j = 0; j < partSize - 1; j++) {
                nodeList.get(index + j).next = nodeList.get(index + j + 1);
            }

            nodeList.get(index + partSize - 1).next = null;
            index += partSize;
        }

        return result;
    }
}
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long total = 0;
        int left = 0, right = n - 1;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int i = 0; i < candidates && left <= right; i++) {
            heap.offer(new int[] { costs[left], left });
            left++;
        }

        for (int i = 0; i < candidates && left <= right; i++) {
            heap.offer(new int[] { costs[right], right });
            right--;
        }

        for (int hired = 0; hired < k; hired++) {
            int[] curr = heap.poll();
            int cost = curr[0];
            int idx = curr[1];
            total += cost;

            if (idx < left) { // Came from left side
                if (left <= right) {
                    heap.offer(new int[] { costs[left], left });
                    left++;
                }
            } else { // Came from right side
                if (left <= right) {
                    heap.offer(new int[] { costs[right], right });
                    right--;
                }
            }
        }

        return total;
    }
}
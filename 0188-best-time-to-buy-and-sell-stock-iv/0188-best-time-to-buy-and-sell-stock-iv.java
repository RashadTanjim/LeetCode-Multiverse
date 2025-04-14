class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0)
            return 0;

        if (k >= n / 2) {
            int maxProfit = 0;

            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        int[] prev = new int[n];
        int[] cur = new int[n];

        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0];

            for (int d = 1; d < n; d++) {
                cur[d] = Math.max(cur[d - 1], prices[d] + maxDiff);
                maxDiff = Math.max(maxDiff, prev[d] - prices[d]);
            }

            int[] temp = prev;
            prev = cur;
            cur = temp;
        }

        return prev[n - 1];
    }
}
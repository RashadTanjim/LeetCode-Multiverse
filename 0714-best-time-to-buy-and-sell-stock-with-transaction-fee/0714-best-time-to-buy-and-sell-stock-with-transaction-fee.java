class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee); // Sell
            hold = Math.max(hold, cash - prices[i]); // Buy
        }

        return cash;
    }
}
// class Solution { // solution - 1 : Kadane's Algorithm -> takes 2ms time
//     public int maxProfit(int[] prices) {

//         int buy = prices[0], maxProfit = 0;

//         for (int i = 1; i < prices.length; i++) {

//             if (prices[i] < buy) { // lower price to buy
//                 buy = prices[i]; // update min price to buy
//             } else if (prices[i] - buy > maxProfit) {
//                 maxProfit = prices[i] - buy; // profit = selling price - buying price
//             }
//         }

//         return maxProfit;
//     }
// }

class Solution {  // solution - 1 : DP -> takes 0ms time
    public int maxProfit(int[] prices) {
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int currentPrice : prices) {
            minPrice = Math.min(currentPrice, minPrice);
            maxProfit = Math.max(maxProfit, currentPrice - minPrice);
        }
        
        return maxProfit;
    }
}
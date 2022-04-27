package _20220427_BestTImeToBuyAndSellStockIII;

public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;

        int[] dp = new int[len];
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= buy) {
                buy = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - buy);
            }
            dp[i] = profit;
        }

        int sell = prices[len - 1];
        profit = 0;
        int max = dp[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (prices[i] >= sell) {
                sell = prices[i];
            } else {
                profit = Math.max(profit, sell - prices[i]);
            }
            max = Math.max(max, dp[i] + profit);
        }

        return max;
    }

}

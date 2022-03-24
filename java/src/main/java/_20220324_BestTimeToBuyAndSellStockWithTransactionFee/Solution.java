package _20220324_BestTimeToBuyAndSellStockWithTransactionFee;

public class Solution {

    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, profit - prices[i]);
            profit = Math.max(profit, buy + prices[i] - fee);
        }

        return profit;
    }

}

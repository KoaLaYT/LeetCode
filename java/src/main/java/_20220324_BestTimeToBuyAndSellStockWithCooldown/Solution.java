package _20220324_BestTimeToBuyAndSellStockWithCooldown;

public class Solution {

    public int maxProfit(int[] prices) {
        int buy = -prices[0];
        int profit = 0;
        int cool = 0;

        for (int i = 1; i < prices.length; i++) {
            int preProfit = profit;
            profit = buy + prices[i];
            buy = Math.max(cool - prices[i], buy);
            cool = Math.max(preProfit, cool);
        }

        return Math.max(profit, cool);
    }

}

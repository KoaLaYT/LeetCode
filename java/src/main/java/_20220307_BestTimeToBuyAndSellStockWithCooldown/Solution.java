package _20220307_BestTimeToBuyAndSellStockWithCooldown;

public class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        int[] cool = new int[prices.length];

        buy[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            sell[i] = buy[i - 1] + prices[i];
            buy[i] = Math.max(cool[i - 1] - prices[i], buy[i - 1]);
            cool[i] = Math.max(sell[i - 1], cool[i - 1]);
        }

        return Math.max(sell[prices.length - 1], cool[prices.length - 1]);
    }

}

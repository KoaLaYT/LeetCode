package _20220307_BestTimeToBuyAndSellStockWithTransactionFee;

public class Solution {

    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) {
            return 0;
        }

        int owned = -prices[0];
        int notOwned = 0;

        for (int i = 1; i < prices.length; i++) {
            owned = Math.max(owned, notOwned - prices[i]);
            notOwned = Math.max(notOwned, owned + prices[i] - fee);
        }

        return notOwned;
    }

}

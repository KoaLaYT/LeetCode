package _20220306_BestTimeToBuyAndSellStockII;

public class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int buyPrice = prices[0];
        int sellPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price < sellPrice) {
                profit += sellPrice - buyPrice;
                buyPrice = sellPrice = price;
            } else {
                sellPrice = price;
            }
        }
        return profit + sellPrice - buyPrice;
    }

}

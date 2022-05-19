package _20220519_BestTimeToBuyAndSellStockIII;

public class Solution {

    public int maxProfit(int[] prices) {
        int fstBuy = Integer.MIN_VALUE;
        int fstSell = 0;
        int sndBuy = Integer.MIN_VALUE;
        int sndSell = 0;

        for (int p : prices) {
            fstBuy = Math.max(fstBuy, -p);
            fstSell = Math.max(fstSell, fstBuy + p);
            sndBuy = Math.max(sndBuy, fstSell - p);
            sndSell = Math.max(sndSell, sndBuy + p);
        }

        return sndSell;
    }

}

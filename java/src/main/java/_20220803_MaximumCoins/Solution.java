package _20220803_MaximumCoins;

public class Solution {

    public int maximum_coins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i < coin) continue;
                if (dp[i - coin] == -1) continue;

                dp[i] = Math.max(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount];
    }

}

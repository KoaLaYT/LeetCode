package _20220803_CoinChange;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (coins == null) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i < coin) continue;
                int prev = dp[i - coin];
                if (prev == -1) continue;

                if (dp[i] == -1) {
                    dp[i] = prev + 1;
                } else {
                    dp[i] = Math.min(dp[i], prev + 1);
                }
            }
        }

        return dp[amount];
    }

}

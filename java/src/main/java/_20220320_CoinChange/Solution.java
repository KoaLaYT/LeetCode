package _20220320_CoinChange;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            memo[i] = amount + 1;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    memo[i] = Math.min(memo[i], memo[i - coin] + 1);
                }
            }
        }
        if (memo[amount] > amount) {
            return -1;
        } else {
            return memo[amount];
        }
    }

}

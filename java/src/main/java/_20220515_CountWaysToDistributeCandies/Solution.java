package _20220515_CountWaysToDistributeCandies;

public class Solution {

    private static final int MOD = 1000000007;

    public int waysToDistribute(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = (j * dp[i - 1][j] + dp[i - 1][j - 1]) % MOD;
            }
        }

        return (int) dp[n][k];
    }

}
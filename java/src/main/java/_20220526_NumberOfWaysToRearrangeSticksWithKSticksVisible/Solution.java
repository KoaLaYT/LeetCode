package _20220526_NumberOfWaysToRearrangeSticksWithKSticksVisible;

public class Solution {

    private static final int MOD = 1000000007;

    public int rearrangeSticks(int n, int k) {
        long[][] dp = new long[n][k + 1];
        dp[0][1] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + i * dp[i - 1][j]) % MOD;
            }
        }

        return (int) dp[n - 1][k];
    }

}

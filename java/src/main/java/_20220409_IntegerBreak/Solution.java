package _20220409_IntegerBreak;

public class Solution {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = i;
            for (int k = 1; i - k >= 1; k++) {
                dp[i] = Math.max(dp[i], k * dp[i - k]);
            }
        }

        for (int i = 1; n - i >= 1; i++) {
            dp[n] = Math.max(dp[n], i * dp[n - i]);
        }

        return dp[n];
    }

}

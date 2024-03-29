package _20220527_New21Game;

public class Solution {

    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) {
            return 1.0;
        }

        if (n == 0) {
            return 0.0;
        }

        double[] dp = new double[k + maxPts];

        for (int i = k; i <= n && i < k + maxPts; i++) {
            dp[i] = 1.0;
        }

        dp[k - 1] = Math.min(n - k + 1, maxPts) / (double) maxPts;

        for (int i = k - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + maxPts + 1] - dp[i + 1]) / maxPts;
        }

        return dp[0];
    }

}

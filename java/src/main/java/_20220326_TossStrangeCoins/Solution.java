package _20220326_TossStrangeCoins;

public class Solution {

    public double probabilityOfHeads(double[] prob, int target) {
        double[][] dp = new double[prob.length + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= prob.length; i++) {
            for (int t = 0; t <= Math.min(i, target); t++) {
                if (t == 0) {
                    dp[i][0] = dp[i - 1][0] * (1 - prob[i - 1]);
                } else {
                    dp[i][t] = dp[i - 1][t - 1] * prob[i - 1] + dp[i - 1][t] * (1 - prob[i - 1]);
                }
            }
        }

        return dp[prob.length][target];
    }

}

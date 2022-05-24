package _20220524_NumberOfDiceRollsWithTargetSum;

public class Solution {

    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k) return 0;
        if (target == n || target == n * k) return 1;

        int[][] dp = new int[n + 1][target + 1];

        for (int i = 1; i <= Math.min(k, target); i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int m = 1; m <= k && j - m > 0; m++) {
                    dp[i][j] += dp[i - 1][j - m];
                    dp[i][j] = Math.floorMod(dp[i][j], 1000000007);
                }
            }
        }

        return dp[n][target];
    }

}

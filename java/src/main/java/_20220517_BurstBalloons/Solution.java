package _20220517_BurstBalloons;

public class Solution {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] nn = new int[n + 2];
        nn[0] = 1;
        nn[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            nn[i] = nums[i - 1];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len + 1 < n + 2; i++) {
                int j = i + len + 1;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], nn[i] * nn[k] * nn[j] + dp[i][k] + dp[k][j]);
                }
            }
        }

        return dp[0][n + 1];
    }

}

package _20220529_MinimumCostToMergeStones;

public class Solution {

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if (isInvalid(n, k)) {
            return -1;
        }

        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + stones[i - 1];
        }

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int m = i; m < j; m += k - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }
                if (!isInvalid(len, k)) {
                    dp[i][j] += prefix[j + 1] - prefix[i];
                }
            }
        }

        return dp[0][n - 1];
    }

    private boolean isInvalid(int len, int k) {
        return (len - 1) % (k - 1) != 0;
    }

}

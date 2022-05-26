package _20220526_BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons;

public class Solution {

    private static final int MOD = 1000000007;

    public int numOfArrays(int n, int m, int k) {
        if (k == 0) {
            return 0;
        }

        long[][][] dp = new long[n][m + 1][k + 1];
        for (int b = 1; b <= m; b++) {
            dp[0][b][1] = 1;
        }

        for (int a = 1; a < n; a++) {
            for (int b = 1; b <= m; b++) {
                for (int c = 1; c <= Math.min(k, n); c++) {
                    dp[a][b][c] = dp[a - 1][b][c] * b % MOD;
                    for (int d = 1; d < b; d++) {
                        dp[a][b][c] = (dp[a][b][c] + dp[a - 1][d][c - 1]) % MOD;
                    }
                }
            }
        }

        long count = 0;
        for (int b = 1; b <= m; b++) {
            count = (count + dp[n - 1][b][k]) % MOD;
        }

        return (int) count;
    }

}

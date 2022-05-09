package _20220509_CherryPickup;

import java.util.Arrays;

public class Solution {

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        dp[0][0] = grid[0][0];

        for (int t = 1; t <= 2 * n - 2; t++) {
            int[][] dp2 = new int[n][n];
            for (int[] row : dp2) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }

            for (int ai = Math.max(0, t - (n - 1)); ai <= Math.min(t, n - 1); ai++) {
                for (int bi = Math.max(0, t - (n - 1)); bi <= Math.min(t, n - 1); bi++) {
                    if (grid[ai][t - ai] == -1 || grid[bi][t - bi] == -1) {
                        continue;
                    }
                    int res = grid[ai][t - ai];
                    if (ai != bi) {
                        res += grid[bi][t - bi];
                    }

                    for (int aai = ai - 1; aai <= ai; aai++) {
                        for (int bbi = bi - 1; bbi <= bi; bbi++) {
                            if (aai >= 0 && bbi >= 0) {
                                dp2[ai][bi] = Math.max(dp2[ai][bi], dp[aai][bbi] + res);
                            }
                        }
                    }
                }
            }
            dp = dp2;
        }

        return Math.max(0, dp[n - 1][n - 1]);
    }

}

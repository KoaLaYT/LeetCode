package _20220521_AllocateMailboxes;

import java.util.Arrays;

public class Solution {

    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int n = houses.length;

        int[][] dp1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int m = i + (j - i) / 2;
                for (int a = i; a <= j; a++) {
                    dp1[i][j] += Math.abs(houses[a] - houses[m]);
                }
            }
        }

        int[][] dp2 = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp2[i][1] = dp1[0][i];
        }

        for (int j = 1; j < n; j++) {
            for (int a = 2; a <= k; a++) {
                dp2[j][a] = Integer.MAX_VALUE;
                for (int i = j - 1; i >= 0; i--) {
                    dp2[j][a] = Math.min(dp2[j][a], dp2[i][a - 1] + dp1[i + 1][j]);
                }
            }
        }

        return dp2[n - 1][k];
    }

}

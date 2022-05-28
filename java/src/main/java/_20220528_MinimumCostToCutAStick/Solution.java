package _20220528_MinimumCostToCutAStick;

import java.util.Arrays;

public class Solution {

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;
        int[] extendedCuts = new int[m + 2];
        System.arraycopy(cuts, 0, extendedCuts, 1, m);
        extendedCuts[0] = 0;
        extendedCuts[m + 1] = n;

        int[][] memo = new int[m + 2][m + 2];
        for (int i = 0; i < m + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                memo[i][j] = -1;
            }
        }
        return minCost(0, m + 1, extendedCuts, memo);
    }

    private int minCost(int lo, int hi, int[] extendedCuts, int[][] memo) {
        if (memo[lo][hi] == -1) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < extendedCuts.length - 1; i++) {
                if (i <= lo || i >= hi) continue;
                min = Math.min(min, minCost(lo, i, extendedCuts, memo) + minCost(i, hi, extendedCuts, memo) + extendedCuts[hi] - extendedCuts[lo]);
            }
            memo[lo][hi] = min == Integer.MAX_VALUE ? 0 : min;
        }
        return memo[lo][hi];
    }

}

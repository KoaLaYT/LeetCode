package _20220917_GuessNumberHigherOrLowerII;

public class Solution {

    public int getMoneyAmount(int n) {
        int[][] memo = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                memo[i][j] = -1;
            }
        }
        return getMoneyAmount(1, n, memo);
    }

    private int getMoneyAmount(int lo, int hi, int[][] memo) {
        if (lo >= hi) {
            return 0;
        }

        if (memo[lo][hi] != -1) {
            return memo[lo][hi];
        }

        int min = Integer.MAX_VALUE;
        for (int i = lo; i <= hi; i++) {
            int max = Math.max(getMoneyAmount(lo, i - 1, memo), getMoneyAmount(i + 1, hi, memo));
            min = Math.min(min, i + max);
        }
        memo[lo][hi] = min;

        return min;
    }

}

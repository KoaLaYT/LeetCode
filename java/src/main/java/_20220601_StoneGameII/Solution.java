package _20220601_StoneGameII;

public class Solution {

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] memo = new int[n][n + 1];
        int[] sums = new int[n];
        sums[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sums[i] = sums[i + 1] + piles[i];
        }

        return stoneGameII(piles, sums, 0, 1, memo);
    }

    private int stoneGameII(int[] piles, int[] sums, int i, int m, int[][] memo) {
        if (i >= piles.length) {
            return 0;
        }

        if (memo[i][m] == 0) {
            int res = 0;

            for (int j = 1; j <= 2 * m && i + j - 1 < piles.length; j++) {
                res = Math.max(res, sums[i] - stoneGameII(piles, sums, i + j, Math.max(m, j), memo));
            }

            memo[i][m] = res;
        }

        return memo[i][m];
    }

}

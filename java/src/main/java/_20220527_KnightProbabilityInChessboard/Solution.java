package _20220527_KnightProbabilityInChessboard;

public class Solution {

    private static final int[][] DIRS = new int[][]{
            {-1, -2},
            {-2, -1},
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2}
    };

    public double knightProbability(int n, int k, int row, int column) {
        if (k == 0) {
            return 1;
        }

        double[][][] dp = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = 1.0;
            }
        }

        for (int t = 1; t <= k; t++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : DIRS) {
                        int ii = i + dir[0];
                        int jj = j + dir[1];
                        if (ii >= 0 && ii < n && jj >= 0 && jj < n) {
                            dp[i][j][t] += dp[ii][jj][t - 1] / 8;
                        }
                    }
                }
            }
        }

        return dp[row][column][k];
    }

}

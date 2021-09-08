package _20210907_UniquePathsII;

/**
 * @author koalayt 2021-09-08
 */
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m <= 0) return 0;

        int n = obstacleGrid[0].length;
        if (n <= 0) return 0;

        if (obstacleGrid[m - 1][n - 1] == 1) return 0;

        int[][] dp = new int[m][n];

        boolean meetObstacle = false;
        for (int i = m - 1; i >= 0; i--) {
            if (!meetObstacle && obstacleGrid[i][n - 1] == 0) {
                dp[i][n - 1] = 1;
            } else {
                meetObstacle = true;
            }
        }

        meetObstacle = false;
        for (int i = n - 1; i >= 0; i--) {
            if (!meetObstacle && obstacleGrid[m - 1][i] == 0) {
                dp[m - 1][i] = 1;
            } else {
                meetObstacle = true;
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }

}

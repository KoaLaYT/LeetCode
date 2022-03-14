package _20220314_UniquePathsII;

public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int j = 1; j < n; j++) {
            dp[j] = obstacleGrid[0][j] == 1 ? 0 : dp[j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = obstacleGrid[i][0] == 1 ? 0 : dp[j];
                } else {
                    dp[j] = obstacleGrid[i][j] == 1 ? 0 : (dp[j - 1] + dp[j]);
                }
            }
        }

        return dp[n - 1];
    }

}

package _20220523_BombEnemy;

public class Solution {

    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        int pre = 0;
        for (int i = 0; i < m; i++) {
            pre = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') pre = 0;
                else if (grid[i][j] == 'E') pre += 1;
                else dp[i][j] += pre;
            }

            pre = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') pre = 0;
                else if (grid[i][j] == 'E') pre += 1;
                else dp[i][j] += pre;
            }
        }

        for (int j = 0; j < n; j++) {
            pre = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 'W') pre = 0;
                else if (grid[i][j] == 'E') pre += 1;
                else dp[i][j] += pre;
            }

            pre = 0;
            for (int i = m - 1; i >= 0; i--) {
                if (grid[i][j] == 'W') pre = 0;
                else if (grid[i][j] == 'E') pre += 1;
                else dp[i][j] += pre;
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

}

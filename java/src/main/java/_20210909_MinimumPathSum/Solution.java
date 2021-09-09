package _20210909_MinimumPathSum;

/**
 * @author koalayt 2021-09-09
 */
public class Solution {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m <= 0) return 0;

        int n = grid[0].length;
        if (n <= 0) return 0;

        for (int i = m - 2; i >= 0; i--) {
            grid[i][n - 1] = grid[i + 1][n - 1] + grid[i][n - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            grid[m - 1][i] = grid[m - 1][i + 1] + grid[m - 1][i];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }

        return grid[0][0];
    }

}

package _20220603_UniquePathIII;

public class Solution {

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int x = 0;
        int y = 0;
        int num = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                } else if (grid[i][j] == 0) {
                    num += 1;
                }
            }
        }

        return uniquePathsIII(grid, num + 1, x, y);
    }

    private int uniquePathsIII(int[][] grid, int num, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }

        if (grid[i][j] == -1) {
            return 0;
        }

        if (grid[i][j] == 2) {
            return num == 0 ? 1 : 0;
        }

        if (num <= 0) {
            return 0;
        }

        grid[i][j] = -1;
        int count = 0;
        count += uniquePathsIII(grid, num - 1, i + 1, j);
        count += uniquePathsIII(grid, num - 1, i - 1, j);
        count += uniquePathsIII(grid, num - 1, i, j + 1);
        count += uniquePathsIII(grid, num - 1, i, j - 1);
        grid[i][j] = 0;
        return count;
    }

}

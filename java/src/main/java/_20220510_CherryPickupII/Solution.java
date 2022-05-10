package _20220510_CherryPickupII;

import java.util.Arrays;

public class Solution {

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] lastRow = new int[n][n]; // 第i-1行两个机器人位于j1, j2时的最大值
        int[][] currRow = new int[n][n]; // 第i行两个机器人位于j1, j2时的最大值
        for (int i = 0; i < n; i++) {
            // -1 代表当前位置不可到达
            Arrays.fill(lastRow[i], -1);
            Arrays.fill(currRow[i], -1);
        }
        lastRow[0][n - 1] = grid[0][0] + grid[0][n - 1];

        for (int i = 1; i < m; i++) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {
                    int max = -1;
                    int value = (j1 == j2 ? grid[i][j1] : grid[i][j1] + grid[i][j2]);
                    for (int dj1 = j1 - 1; dj1 <= j1 + 1; dj1++) {
                        for (int dj2 = j2 - 1; dj2 <= j2 + 1; dj2++) {
                            if (dj1 >= 0 && dj1 < n && dj2 >= 0 && dj2 < n && lastRow[dj1][dj2] != -1) {
                                max = Math.max(max, lastRow[dj1][dj2] + value);
                            }
                        }
                    }
                    currRow[j1][j2] = max;
                }
            }
            int[][] temp = lastRow;
            lastRow = currRow;
            currRow = temp;
        }

        int max = 0;
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                max = Math.max(max, lastRow[j1][j2]);
            }
        }

        return max;
    }

}

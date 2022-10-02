package _20221002_PacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacificReachable = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacificReachable);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacificReachable);
        }

        boolean[][] atlanticReachable = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, i, n - 1, atlanticReachable);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, m - 1, j, atlanticReachable);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] reachable) {
        if (reachable[i][j]) {
            return;
        }

        reachable[i][j] = true;

        if (i - 1 >= 0 && heights[i][j] <= heights[i - 1][j]) {
            dfs(heights, i - 1, j, reachable);
        }
        if (j + 1 < heights[0].length && heights[i][j] <= heights[i][j + 1]) {
            dfs(heights, i, j + 1, reachable);
        }
        if (i + 1 < heights.length && heights[i][j] <= heights[i + 1][j]) {
            dfs(heights, i + 1, j, reachable);
        }
        if (j - 1 >= 0 && heights[i][j] <= heights[i][j - 1]) {
            dfs(heights, i, j - 1, reachable);
        }
    }

}

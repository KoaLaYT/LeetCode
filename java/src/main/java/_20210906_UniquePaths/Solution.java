package _20210906_UniquePaths;

/**
 * @author koalayt 2021-09-06
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];

        for (int i = 0; i < m; i++) {
            map[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            map[m - 1][i] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                map[i][j] = map[i + 1][j] + map[i][j + 1];
            }
        }

        return map[0][0];
    }

}

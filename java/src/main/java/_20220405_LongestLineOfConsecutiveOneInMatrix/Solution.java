package _20220405_LongestLineOfConsecutiveOneInMatrix;

public class Solution {

    public int longestLine(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][][] dp = new int[m + 1][n + 2][4];

        int max = 0;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (mat[i - 1][j - 1] == 1) {
                    dp[i][j][0] = dp[i][j - 1][0] + 1;// horizontal
                    dp[i][j][1] = dp[i - 1][j][1] + 1; // vertical
                    dp[i][j][2] = dp[i - 1][j - 1][2] + 1; // diagonal
                    dp[i][j][3] = dp[i - 1][j + 1][3] + 1; // anti-diagonal
                    max = max(max, dp[i][j][0], dp[i][j][1], dp[i][j][2], dp[i][j][3]);
                }
            }
        }

        return max;
    }

    private int max(int a, int b, int c, int d, int e) {
        return Math.max(a, Math.max(b, Math.max(c, Math.max(d, e))));
    }

}

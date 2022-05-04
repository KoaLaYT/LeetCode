package _20220504_EditDistance;

public class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        char[] ww1 = word1.toCharArray();
        char[] ww2 = word2.toCharArray();

        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = ww1[0] == ww2[0] ? 0 : 1;

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (ww1[i - 1] == ww2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}

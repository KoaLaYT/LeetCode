package _20220506_ShortestCommonSuperSequence;

public class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        char[] ss1 = str1.toCharArray();
        char[] ss2 = str2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (ss1[i - 1] == ss2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder css = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (ss1[i - 1] == ss2[j - 1]) {
                css.append(ss1[i - 1]);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                css.append(ss1[--i]);
            } else {
                css.append(ss2[--j]);
            }
        }

        while (i > 0) {
            css.append(ss1[--i]);
        }

        while (j > 0) {
            css.append(ss2[--j]);
        }

        return css.reverse().toString();
    }

}

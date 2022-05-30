package _20220530_StrangePrinter;

public class Solution {

    public int strangePrinter(String s) {
        int n = s.length();
        char[] ss = s.toCharArray();
        int[][] dp = new int[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (i == j) {
                    dp[i][j] = 1;
                } else if (ss[j] == ss[j - 1]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + 1;
                    for (int k = j - 1; k >= i; k--) {
                        if (ss[k] == ss[j]) {
                            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j - 1]);
                        }
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

}

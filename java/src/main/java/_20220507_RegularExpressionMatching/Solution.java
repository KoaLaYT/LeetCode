package _20220507_RegularExpressionMatching;

public class Solution {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pp[j - 1] == '*') {
                    if (isMatch(ss, pp, i, j - 1)) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    if (isMatch(ss, pp, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[m][n];
    }

    private boolean isMatch(char[] ss, char[] pp, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (pp[j - 1] == '.') {
            return true;
        }
        return ss[i - 1] == pp[j - 1];
    }

}

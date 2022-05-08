package _20220508_MinimumWindowSubsequence;

public class Solution {

    public String minWindow(String s1, String s2) {
        int m = s2.length();
        int n = s1.length();

        if (n < m) {
            return "";
        }

        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();

        int[][] dp = new int[m][n];
        dp[0][0] = ss1[0] == ss2[0] ? 0 : -1;

        for (int j = 1; j < n; j++) {
            dp[0][j] = ss1[j] == ss2[0] ? j : dp[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j < i) {
                    dp[i][j] = -1;
                } else if (ss1[j] == ss2[i]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        int lo = -1;
        int hi = n;
        for (int j = 0; j < n; j++) {
            int pos = dp[m - 1][j];
            if (pos != -1 && j - pos < hi - lo) {
                lo = pos;
                hi = j;
            }
        }

        return lo == -1 ? "" : s1.substring(lo, hi + 1);
    }

}

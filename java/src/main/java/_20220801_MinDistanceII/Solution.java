package _20220801_MinDistanceII;

public class Solution {

    public int edit_distance(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= Math.min(i, n); j++) {
                int d = ss[i - 1] == tt[j - 1] ? 0 : 1;
                if (i == j) {
                    dp[i][j] = dp[i - 1][j - 1] + d;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + d, dp[i - 1][j] + 1);
                }
            }
        }

        return dp[m][n];
    }

}

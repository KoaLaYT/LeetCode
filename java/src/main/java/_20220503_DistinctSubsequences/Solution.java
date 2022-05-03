package _20220503_DistinctSubsequences;

public class Solution {

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[][] dp = new int[m + 1][n];

        for (int i = m - 1; i >= 0; i--) {
            dp[i][n - 1] = (ss[i] == tt[n - 1] ? 1 : 0) + dp[i + 1][n - 1];
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (ss[i] == tt[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }

}

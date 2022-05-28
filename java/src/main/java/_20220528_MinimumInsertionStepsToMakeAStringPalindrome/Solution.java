package _20220528_MinimumInsertionStepsToMakeAStringPalindrome;

public class Solution {

    public int minInsertions(String s) {
        int n = s.length();
        char[] ss = s.toCharArray();
        int[][] dp = new int[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n; i > 0; i--) {
            for (int j = i+1; j <= n; j++) {
                if (ss[i - 1] == ss[j - 1]) {
                    dp[i][j] = 2 + dp[i + 1][j -1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return n - dp[1][n];
    }

}

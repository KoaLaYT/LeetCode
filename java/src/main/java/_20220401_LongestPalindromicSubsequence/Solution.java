package _20220401_LongestPalindromicSubsequence;

public class Solution {

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        char[] c = s.toCharArray();
        int[][] dp = new int[len + 1][len + 1];

        for (int i = len; i > 0; i--) {
            for (int j = i; j <= len; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                if (c[i - 1] == c[j - 1]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[1][len];
    }

}

package _20220316_LongestPalindromicSubsequence;

public class Solution {

    public int longestPalindromeSubseq(String s) {
        int len = s.length();

        int[][] dp = new int[len][];
        for (int i = 0; i < len; i++) {
            dp[i] = new int[len];
            dp[i][i] = 1;
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][len - 1];
    }

}

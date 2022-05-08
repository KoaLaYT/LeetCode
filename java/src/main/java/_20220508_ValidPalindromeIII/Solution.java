package _20220508_ValidPalindromeIII;

public class Solution {

    public boolean isValidPalindrome(String s, int k) {
        int len = s.length();
        char[] ss = s.toCharArray();
        int[][] dp = new int[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (ss[i] == ss[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return (len - dp[0][len - 1]) <= k;
    }

}

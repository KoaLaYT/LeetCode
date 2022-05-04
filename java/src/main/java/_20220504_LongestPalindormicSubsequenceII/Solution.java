package _20220504_LongestPalindormicSubsequenceII;

public class Solution {

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        char[] ss = s.toCharArray();
        int[][] dp = new int[len][len]; // longest palindromic subseq between [i,j]
        int[][] cc = new int[len][len]; // last consecutive characters between [i,j]

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                boolean isValid = ss[i] == ss[j] && ss[i] != cc[i + 1][j - 1];
                int l = isValid ? 2 : 0;

                int r1 = l + dp[i + 1][j - 1];
                int c1 = isValid ? ss[i] : cc[i + 1][j - 1];

                int r2 = dp[i + 1][j];
                int c2 = cc[i + 1][j];

                int r3 = dp[i][j - 1];
                int c3 = cc[i][j - 1];

                if (r1 >= r2 && r1 >= r3) {
                    dp[i][j] = r1;
                    cc[i][j] = c1;
                } else if (r2 >= r1 && r2 >= r3) {
                    dp[i][j] = r2;
                    cc[i][j] = c2;
                } else {
                    dp[i][j] = r3;
                    cc[i][j] = c3;
                }
            }
        }

        return dp[0][len - 1];
    }

}

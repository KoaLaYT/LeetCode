package _20220529_PalindromePartitioningIII;

public class Solution {

    public int palindromePartition(String s, int k) {
        int n = s.length();
        char[] ss = s.toCharArray();

        int[][] cost = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (ss[i] == ss[j]) {
                    cost[i][j] = cost[i + 1][j - 1];
                } else {
                    cost[i][j] = cost[i + 1][j - 1] + 1;
                }
            }
        }

        int[][] dp = new int[n][k + 1];
        for (int j = 1; j < n; j++) {
            dp[j][1] = cost[0][j];
        }

        for (int j = 1; j < n; j++) {
            for (int m = 2; m <= k; m++) {
                if (j <= m - 1) continue;
                dp[j][m] = Integer.MAX_VALUE;
                for (int i = j - 1; i >= m - 2; i--) {
                    dp[j][m] = Math.min(dp[j][m], dp[i][m - 1] + cost[i + 1][j]);
                }
            }
        }

        return dp[n - 1][k];
    }

}

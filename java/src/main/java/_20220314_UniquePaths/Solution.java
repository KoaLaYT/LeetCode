package _20220314_UniquePaths;

public class Solution {

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = i + 1;
        }

        for (int i = 2; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }

}

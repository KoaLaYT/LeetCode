package _20220312_MinimumFallingPathSum;

public class Solution {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        if (n <= 0) {
            return 0;
        }

        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum = Math.min(sum, matrix[0][i]);
        }
        for (int i = 1; i < n; i++) {
            int[] dp = matrix[i - 1];
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    matrix[i][j] += Math.min(dp[j], dp[j + 1]);
                    sum = matrix[i][j];
                    continue;
                }

                if (j == n - 1) {
                    matrix[i][j] += Math.min(dp[j - 1], dp[j]);
                } else {
                    matrix[i][j] += Math.min(Math.min(dp[j - 1], dp[j]), dp[j + 1]);
                }
                sum = Math.min(sum, matrix[i][j]);
            }
        }

        return sum;
    }

}

package _20220320_IntegerBreak;

public class Solution {

    public int integerBreak(int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 1; j <= i; j++) {
                max = Math.max(max, j * dp[i - j]);
            }
            dp[i] = max;
        }

        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, i * dp[n - i]);
        }

        return max;
    }

}

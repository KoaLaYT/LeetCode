package _20220915_CountNumbersWithUniqueDigits;

public class Solution {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 10;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 9;
        int sum = 10;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * (9 - i + 2);
            sum += dp[i];
        }

        return sum;
    }

}

package _20220310_UglyNumberII;

public class Solution {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
            dp[i] = min;
            if (min == dp[p2] * 2) p2++;
            if (min == dp[p3] * 3) p3++;
            if (min == dp[p5] * 5) p5++;
        }

        return dp[n - 1];
    }

}

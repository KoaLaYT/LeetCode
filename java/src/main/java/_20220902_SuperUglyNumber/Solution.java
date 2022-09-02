package _20220902_SuperUglyNumber;

import java.util.Arrays;

public class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }

        int[] pointers = new int[primes.length];
        Arrays.fill(pointers, 1);

        long[] dp = new long[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            long min = Long.MAX_VALUE;
            for (int p = 0; p < primes.length; p++) {
                min = Math.min(min, dp[pointers[p]] * primes[p]);
            }
            for (int p = 0; p < primes.length; p++) {
                if (min == dp[pointers[p]] * primes[p]) {
                    pointers[p] += 1;
                }
            }
            dp[i] = min;
        }

        return (int) dp[n];
    }

}

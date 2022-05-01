package _20220501_MaximumNumberOfEventsThatCanBeAttededII;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(e -> e[0]));

        int[][] dp = new int[events.length][k + 1];
        for (int i = 1; i <= k; i++) {
            dp[events.length - 1][i] = events[events.length - 1][2];
        }

        for (int i = events.length - 2; i >= 0; i--) {
            int v = events[i][2];
            int nextI = binarySearch(events, i);
            for (int j = 1; j <= k; j++) {
                if (nextI >= events.length) {
                    dp[i][j] = Math.max(v, dp[i + 1][j]);
                } else {
                    dp[i][j] = Math.max(v + dp[nextI][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][k];
    }

    private int binarySearch(int[][] events, int a) {
        int target = events[a][1];
        int lo = a + 1;
        int hi = events.length - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (events[mi][0] <= target) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }
        return lo;
    }

}

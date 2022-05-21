package _20220521_MaximumNumberOfEventsThatCanBeAttendedII;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(e -> e[1]));

        int n = events.length;
        int[][] dp = new int[n][k + 1];
        for (int i = 1; i <= k; i++) {
            dp[0][i] = events[0][2];
        }

        for (int i = 1; i < n; i++) {
            int lastI = search(events, i, events[i][0]);
            int v = events[i][2];
            for (int j = 1; j <= k; j++) {
                if (lastI >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[lastI][j - 1] + v);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], v);
                }
            }
        }

        return dp[n - 1][k];
    }

    private int search(int[][] events, int index, int startDay) {
        int lo = 0;
        int hi = index - 1;

        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (events[mi][1] < startDay) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }

        return lo - 1;
    }

}

package _20220501_MaximumProfitInJobScheduling;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        int[][] jobs = new int[len][3];
        for (int i = 0; i < len; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));

        int[] dp = new int[len];
        dp[len - 1] = jobs[len - 1][2];

        for (int i = startTime.length - 2; i >= 0; i--) {
            int j = binarySearch(jobs, i);
            int v = jobs[i][2];
            dp[i] = Math.max(v + (j >= len ? 0 : dp[j]), dp[i + 1]);
        }
        return dp[0];
    }

    private int binarySearch(int[][] jobs, int a) {
        int target = jobs[a][1];
        int lo = a + 1;
        int hi = jobs.length - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (jobs[mi][0] < target) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }
        return lo;
    }

}

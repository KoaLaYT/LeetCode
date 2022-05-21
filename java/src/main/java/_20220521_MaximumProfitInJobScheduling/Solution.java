package _20220521_MaximumProfitInJobScheduling;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = buildJobs(startTime, endTime, profit);
        return jobScheduling(jobs);
    }

    private int jobScheduling(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(job -> job[1]));
        int n = jobs.length;
        int[] dp = new int[n];
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            int lastI = search(jobs, i, jobs[i][0]);
            int v = jobs[i][2];
            if (lastI >= 0) {
                dp[i] = Math.max(dp[i - 1], dp[lastI] + v);
            } else {
                dp[i] = Math.max(dp[i - 1], v);
            }
        }

        return dp[n - 1];
    }

    private int search(int[][] jobs, int index, int startDay) {
        while (--index >= 0) {
            if (jobs[index][1] <= startDay) {
                break;
            }
        }
        return index;
    }

    private int[][] buildJobs(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        return jobs;
    }

}

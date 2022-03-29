package _20220329_NumberOfLongestIncreasingSubsequence;

import java.util.Arrays;

public class Solution {

    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int[] combs = new int[len];

        Arrays.fill(dp, 1);
        Arrays.fill(combs, 1);

        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        combs[i] = combs[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        combs[i] += combs[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == max) {
                res += combs[i];
            }
        }

        return res;
    }

}

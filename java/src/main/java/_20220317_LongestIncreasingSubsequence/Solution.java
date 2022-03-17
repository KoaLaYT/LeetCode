package _20220317_LongestIncreasingSubsequence;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        int max = 0;
        for (int num : nums) {
            int index = binarySearch(dp, num, max - 1);
            dp[index] = num;
            if (index == max) {
                max++;
            }
        }

        return max;
    }

    private int binarySearch(int[] nums, int num, int lastIndex) {
        int lo = 0;
        int hi = lastIndex;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (num == nums[mi]) {
                return mi;
            } else if (num < nums[mi]) {
                hi = mi - 1;
            } else {
                lo = mi + 1;
            }
        }
        return lo;
    }

}

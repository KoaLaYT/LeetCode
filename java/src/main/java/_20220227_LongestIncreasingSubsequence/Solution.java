package _20220227_LongestIncreasingSubsequence;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int index = binarySearch(dp, num, len);
            if (index == len) {
                len++;
            }
            dp[index] = num;
        }
        return len;
    }

    private int binarySearch(int[] dp, int num, int len) {
        if (len == 0 || num > dp[len - 1]) {
            return len;
        }
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dp[mid] >= num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}

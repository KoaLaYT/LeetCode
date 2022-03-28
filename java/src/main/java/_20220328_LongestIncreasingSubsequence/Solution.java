package _20220328_LongestIncreasingSubsequence;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = -1;

        for (int num : nums) {
            int len = binarySearch(dp, num, max);
            if (len > max) {
                max++;
            }
        }

        return max + 1;
    }

    private int binarySearch(int[] nums, int num, int len) {
        int lo = 0;
        int hi = len;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] == num) {
                lo = mi;
                break;
            } else if (nums[mi] < num) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }
        nums[lo] = num;
        return lo;
    }

}

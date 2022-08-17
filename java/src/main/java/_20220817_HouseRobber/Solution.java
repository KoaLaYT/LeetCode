package _20220817_HouseRobber;

import java.util.Arrays;

public class Solution {

    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, 0, memo);
    }

    private int rob(int[] nums, int i, int[] memo) {
        if (i >= nums.length) return 0;

        if (memo[i] < 0) {
            memo[i] = Math.max(nums[i] + rob(nums, i + 2, memo), rob(nums, i + 1, memo));
        }

        return memo[i];
    }

}

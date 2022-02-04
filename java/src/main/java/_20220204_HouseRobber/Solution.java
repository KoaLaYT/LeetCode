package _20220204_HouseRobber;

import java.util.Arrays;

public class Solution {

    public int rob(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] memo = new int[nums.length - 1];
        Arrays.fill(memo, -1);

        return rob(nums, 0, nums.length - 1, memo);
    }

    private int rob(int[] nums, int i, int j, int[] memo) {
        if (i >= nums.length) {
            return 0;
        }

        int size = j - i + 1;
        if (size <= 0) {
            return 0;
        }

        if (size == 1) {
            return nums[i];
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int v1 = nums[i] + rob(nums, i + 2, j, memo);
        int v2 = rob(nums, i + 1, j, memo);
        return memo[i] = Math.max(v1, v2);
    }
}

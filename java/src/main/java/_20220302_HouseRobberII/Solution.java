package _20220302_HouseRobberII;

import java.util.Arrays;

public class Solution {

    public int rob(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] memo = new int[nums.length];

        Arrays.fill(memo, -1);
        int v1 = rob(nums, 0, nums.length - 2, memo);

        Arrays.fill(memo, -1);
        int v2 = rob(nums, 1, nums.length - 1, memo);

        return Math.max(v1, v2);
    }

    private int rob(int[] nums, int i, int j, int[] memo) {
        if (i > j) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int v1 = nums[i] + rob(nums, i + 2, j, memo);
        int v2 = rob(nums, i + 1, j, memo);
        return memo[i] = Math.max(v1, v2);
    }

}

package _20220322_HouseRobberII;

public class Solution {

    public int rob(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }

        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int v1 = rob(nums, 0, len - 2);
        int v2 = rob(nums, 1, len - 1);

        return Math.max(v1, v2);
    }

    private int rob(int[] nums, int i, int j) {
        int len = j - i + 2;
        int[] dp = new int[len];
        dp[j] = nums[j];
        dp[j - 1] = Math.max(nums[j], nums[j - 1]);

        for (int k = j - 2; k >= i; k--) {
            dp[k] = Math.max(nums[k] + dp[k + 2], dp[k + 1]);
        }

        return Math.max(dp[i], dp[i+1]);
    }

}

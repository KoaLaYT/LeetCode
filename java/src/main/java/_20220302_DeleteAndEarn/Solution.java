package _20220302_DeleteAndEarn;

public class Solution {

    public int deleteAndEarn(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }

        int len = 0;
        for (int num : nums) {
            len = Math.max(len, num);
        }
        int[] trans = new int[len + 1];
        for (int num : nums) {
            trans[num] += num;
        }

        int[] dp = new int[len + 1];
        dp[0] = trans[0];
        dp[1] = trans[1];

        for (int i = 2; i < len + 1; i++) {
            dp[i] = Math.max(dp[i - 1], trans[i] + dp[i - 2]);
        }

        return dp[len];
    }

}

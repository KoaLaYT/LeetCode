package _20220314_NextGreaterElementII;

public class Solution {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;

        int maxIndex = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int[] dp = new int[len];
        int[] res = new int[len];
        dp[maxIndex] = -1;
        res[maxIndex] = -1;
        for (int i = 1; i < len; i++) {
            int j = (maxIndex - i + len) % len;
            int k = (j + 1) % len;

            while (nums[j] >= nums[k]) {
                k = dp[k];
                if (k == -1) {
                    break;
                }
            }

            dp[j] = k;
            if (k == -1) {
                res[j] = -1;
            } else {
                res[j] = nums[k];
            }
        }

        return res;
    }

}

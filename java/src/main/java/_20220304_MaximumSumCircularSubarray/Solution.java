package _20220304_MaximumSumCircularSubarray;

public class Solution {

    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int preMax = nums[0];
        int max = nums[0];

        int preMin = nums[0];
        int min = nums[0];

        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            preMax = Math.max(nums[i], preMax + nums[i]);
            max = Math.max(preMax, max);
            preMin = Math.min(nums[i], preMin + nums[i]);
            min = Math.min(preMin, min);
            sum += nums[i];
        }

        if (max < 0) {
            return max;
        }

        return Math.max(max, sum - min);
    }

}

package _20220610_MaxSubArraySumCircular;

public class Solution {

    public int maxSubarraySumCircular(int[] nums) {
        int preMax = nums[0];
        int max = nums[0];
        int preMin = nums[0];
        int min = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            preMax = Math.max(preMax + nums[i], nums[i]);
            max = Math.max(max, preMax);
            preMin = Math.min(preMin + nums[i], nums[i]);
            min = Math.min(min, preMin);
            sum += nums[i];
        }

        if (max < 0) {
            return max;
        }

        return Math.max(max, sum - min);
    }

}

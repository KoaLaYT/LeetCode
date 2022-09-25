package _20220925_RotateFunction;

public class Solution {

    public int maxRotateFunction(int[] nums) {
        int f = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            f += i * nums[i];
            sum += nums[i];
        }

        int max = f;
        for (int i = nums.length - 1; i >= 1; i--) {
            f = f - (nums.length - 1) * nums[i] + (sum - nums[i]);
            max = Math.max(max, f);
        }

        return max;
    }

}

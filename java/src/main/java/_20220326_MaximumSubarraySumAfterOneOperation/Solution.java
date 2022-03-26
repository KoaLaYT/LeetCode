package _20220326_MaximumSubarraySumAfterOneOperation;

public class Solution {

    public int maxSumAfterOperation(int[] nums) {
        int noDouble = nums[0];
        int oneDouble = nums[0] * nums[0];

        int max = oneDouble;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            oneDouble = Math.max(num * num, Math.max(noDouble + num * num, oneDouble + num));
            noDouble = Math.max(noDouble + num, num);

            max = Math.max(max, oneDouble);
        }

        return max;
    }

}

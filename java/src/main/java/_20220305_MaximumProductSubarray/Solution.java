package _20220305_MaximumProductSubarray;

public class Solution {

    public int maxProduct(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }

        if (nums.length <= 1) {
            return nums[0];
        }

        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }

}

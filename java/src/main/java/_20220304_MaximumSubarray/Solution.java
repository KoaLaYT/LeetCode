package _20220304_MaximumSubarray;

public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }

        int pre = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            result = Math.max(result, pre);
        }

        return result;
    }

}

package _20220322_MaximumSubarray;

public class Solution {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = max;
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }

}

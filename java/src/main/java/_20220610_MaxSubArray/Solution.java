package _20220610_MaxSubArray;

public class Solution {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = nums[0];

        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }

        return max;
    }

}

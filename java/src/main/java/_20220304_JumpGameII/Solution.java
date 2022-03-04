package _20220304_JumpGameII;

public class Solution {

    public int jump(int[] nums) {
        if (nums[0] == 0 || nums.length <= 1) {
            return 0;
        }

        int maxPos = 0;
        int end = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                steps++;
            }
        }
        return steps;
    }

}

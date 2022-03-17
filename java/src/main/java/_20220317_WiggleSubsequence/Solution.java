package _20220317_WiggleSubsequence;

public class Solution {

    public int wiggleMaxLength(int[] nums) {
        int down = 1;
        int up = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }

        return Math.max(up, down);
    }

}

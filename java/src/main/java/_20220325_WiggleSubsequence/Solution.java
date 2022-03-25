package _20220325_WiggleSubsequence;

public class Solution {

    enum Direction {
        NONE,
        UP,
        DOWN
    }

    public int wiggleMaxLength(int[] nums) {
        Direction direction = Direction.NONE;

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                if (direction != Direction.UP) {
                    max++;
                }
                direction = Direction.UP;
            }

            if (nums[i] < nums[i - 1]) {
                if (direction != Direction.DOWN) {
                    max++;
                }
                direction = Direction.DOWN;
            }
        }

        return max;
    }

}

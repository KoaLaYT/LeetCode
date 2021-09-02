package _20210902_JumpGame;

/**
 * @author koalayt 2021-09-02
 */
public class Solution {

    public boolean canJump(int[] nums) {
        int lastPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }

}

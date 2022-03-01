package _20220301_MonotonicArray;

public class Solution {

    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }

        long dir = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }
            int currDir = nums[i] - nums[i-1];
            if (dir == 0) {
                dir = currDir;
                continue;
            }
            if (currDir * dir < 0) {
                return false;
            }
        }

        return true;
    }

}

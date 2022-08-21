package _20220821_ContainsDuplicateIII;

import java.util.TreeSet;

public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> win = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Long ceiling = win.ceiling(nums[i] - (long) t);
            if (ceiling != null && ceiling <= nums[i] + (long) t) {
                return true;
            }
            win.add((long) nums[i]);
            if (i - k >= 0) {
                win.remove((long) nums[i - k]);
            }
        }

        return false;
    }

}

package _20210919_SearchInRotatedSortedArrayII;

/**
 * @author koalayt 2021-09-19
 */
public class Solution {

    public boolean search(int[] nums, int target) {
        if (nums.length <= 0) return false;

        int first = nums[0];
        if (first == target) {
            return true;
        }
        if (first < target) {
            return searchFromFront(nums, target);
        } else {
            return searchFromBack(nums, target);
        }
    }

    private boolean searchFromFront(int[] nums, int target) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
            if (i < nums.length - 1 && nums[i + 1] < nums[i]) {
                return false;
            }
        }
        return false;
    }

    private boolean searchFromBack(int[] nums, int target) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                return true;
            }
            if (i > 0 && nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return false;
    }

}

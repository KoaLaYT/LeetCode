package _20220612_SearchRotatedSortedArray;

public class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] == target) {
                return mi;
            }
            // [lo, mi - 1] part is sorted.
            if (nums[lo] < nums[mi]) {
                if (mi - 1 >= 0 && nums[lo] <= target && nums[mi - 1] >= target) {
                    return binarySearch(nums, lo, mi - 1, target);
                } else {
                    lo = mi + 1;
                }
            }
            // [mi + 1, hi] part is sorted.
            else {
                if (mi + 1 < nums.length && nums[mi + 1] <= target && nums[hi] >= target) {
                    return binarySearch(nums, mi + 1, hi, target);
                } else {
                    hi = mi - 1;
                }
            }
        }

        return -1;
    }

    private int binarySearch(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] == target) {
                return mi;
            }
            if (nums[mi] < target) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }
        return -1;
    }

}

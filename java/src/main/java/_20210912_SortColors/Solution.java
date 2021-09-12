package _20210912_SortColors;

/**
 * @author koalayt 2021-09-12
 */
public class Solution {

    public void sortColors(int[] nums) {
        // find first zero, swap it to first slot.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, 0);
                break;
            }
        }

        // no zeros, only 1 or 2.
        if (nums[0] != 0) {
            int i = 0;
            int j = nums.length - 1;
            while (i <= j) {
                if (nums[i] == 1) {
                    i++;
                } else {
                    swap(nums, i, j);
                    j--;
                }
            }
            return;
        }

        int i = 1;
        int i0 = 1;
        int i2 = nums.length - 1;
        while (i <= i2) {
            if (nums[i] == 0) {
                swap(nums, i, i0);
                i0++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else { // nums[i] == 2
                swap(nums, i, i2);
                i2--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}

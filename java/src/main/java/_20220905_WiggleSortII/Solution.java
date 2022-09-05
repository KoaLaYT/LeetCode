package _20220905_WiggleSortII;

import java.util.Arrays;

public class Solution {

    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int[] sorted = Arrays.copyOf(nums, len);
        Arrays.sort(sorted);

        int index = len - 1;
        for (int i = 1; i < len; i += 2) {
            nums[i] = sorted[index--];
        }

        for (int i = 0; i < len; i += 2) {
            nums[i] = sorted[index--];
        }
    }

}

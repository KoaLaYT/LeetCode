package _20210918_RemoveDuplicatesFromSortedArrayII;

/**
 * @author koalayt 2021-09-18
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int removedIndex = 0;
        int duplicateLength = 1;
        int index = 1;

        while (index < nums.length) {
            if (nums[index] != nums[index - 1]) {
                for (int i = 0; i < Math.min(duplicateLength, 2); i++) {
                    nums[removedIndex++] = nums[index - 1];
                }
                duplicateLength = 1;
            } else {
                duplicateLength++;
            }
            index++;
        }

        for (int i = 0; i < Math.min(duplicateLength, 2); i++) {
            nums[removedIndex++] = nums[index - 1];
        }

        return removedIndex;
    }

}

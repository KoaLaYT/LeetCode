package _20220609_NextPermutation;

public class Solution {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) break;
            else i--;
        }

        if (i != -1) {
            int j = i + 1;
            for (int k = i + 2; k < nums.length; k++) {
                if (nums[k] > nums[i] && nums[k] <= nums[j]) {
                    j = k;
                }
            }
            swap(nums, i, j);
        }

        i++;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}

package _20220612_SortedAray3Sum;

public class Solution {

    public int[] sortedArray3Sum(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return new int[]{-1, -1, -1};
        }

        for (int p = 0; p < nums.length; p++) {
            int i = p + 1;
            int j = nums.length - 1;
            int sum = target - nums[p];
            while (i < j) {
                int s = nums[i] + nums[j];
                if (s == sum) {
                    return new int[]{p, i, j};
                }
                if (s < sum) {
                    i += 1;
                } else {
                    j -= 1;
                }
            }
        }

        return new int[]{-1, -1, -1};
    }

}

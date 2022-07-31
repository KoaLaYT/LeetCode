package _20220731_FiveSum;

import java.util.Arrays;

public class Solution {

    public boolean five_sum(int[] nums, int target) {
        Arrays.sort(nums);

        for (int a = 0; a < nums.length; a++) {
            if (nums[a] >= target) break;
            for (int b = a + 1; b < nums.length; b++) {
                if (nums[a] + nums[b] >= target) break;
                for (int c = b + 1; c < nums.length; c++) {
                    if (nums[a] + nums[b] + nums[c] >= target) break;
                    for (int d = c + 1; d < nums.length; d++) {
                        if (nums[a] + nums[b] + nums[c] + nums[d] >= target) break;
                        for (int e = d + 1; e < nums.length; e++) {
                            int sum = nums[a] + nums[b] + nums[c] + nums[d] + nums[e];
                            if (sum == target) return true;
                            if (sum > target) break;
                        }
                    }
                }
            }
        }

        return false;
    }

}

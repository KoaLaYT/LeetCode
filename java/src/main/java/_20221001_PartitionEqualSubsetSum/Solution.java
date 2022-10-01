package _20221001_PartitionEqualSubsetSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        if (sum % 2 == 1) return false;

        int target = sum / 2;
        if (max == target) return true;
        if (max > target) return false;

        Map<Integer, Integer> memo = new HashMap<>();
        return canPartition(nums, memo, 0, 0, target);
    }

    private boolean canPartition(int[] nums, Map<Integer, Integer> memo, int start, int sum, int target) {
        if (sum == target) {
            return true;
        }

        if (sum > target) {
            return false;
        }

        if (memo.getOrDefault(sum, nums.length) <= start) {
            return false;
        }

        for (int i = start; i < nums.length; i++) {
            boolean found = canPartition(nums, memo, i + 1, sum + nums[i], target);
            if (found) return true;
        }

        memo.put(sum, start);
        return false;
    }

}

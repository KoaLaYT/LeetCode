package _20220608_ArrayIntervalSum;

public class Solution {

    public int[] array_interval_sum(int[] nums, int[][] queries) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            result[i] = sums[query[1]] - sums[query[0] - 1];
        }
        return result;
    }

}

package _20220608_TwoDimensionArrayIntervalSum;

public class Solution {

    public int[] two_dimension_array_interval_sum(int[][] nums, int[][] queries) {
        int n = nums.length;
        int m = nums[0].length;
        int[][] sums = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= m; j++) {
                sum += nums[i - 1][j - 1];
                sums[i][j] = sum + sums[i - 1][j];
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            result[i] = sums[query[2]][query[3]] - sums[query[0] - 1][query[3]] - sums[query[2]][query[1] - 1] + sums[query[0] - 1][query[1] - 1];
        }

        return result;
    }

}

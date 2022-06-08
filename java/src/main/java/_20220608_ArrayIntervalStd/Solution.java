package _20220608_ArrayIntervalStd;

public class Solution {

    public double[] array_interval_std(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] squareSums = new int[n + 1];
        int[] sums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            squareSums[i] = squareSums[i - 1] + nums[i - 1] * nums[i - 1];
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int squareSum = squareSums[query[1]] - squareSums[query[0] - 1];
            int sum = sums[query[1]] - sums[query[0] - 1];
            int len = query[1] - query[0] + 1;
            result[i] = (squareSum - (double)(sum * sum) / len) / len;
        }

        return result;
    }

}

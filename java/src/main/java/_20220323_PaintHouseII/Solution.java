package _20220323_PaintHouseII;

public class Solution {

    public int minCostII(int[][] costs) {
        int k = costs[0].length;

        int min = 0;
        int secondMin = 0;
        int minIndex = -1;

        for (int[] cost : costs) {
            int currentMin = Integer.MAX_VALUE;
            int currentSecondMin = Integer.MIN_VALUE;
            int currentMinIndex = -1;

            for (int i = 0; i < k; i++) {
                int val = cost[i] + (i != minIndex ? min : secondMin);

                if (val < currentMin) {
                    currentSecondMin = currentMin;
                    currentMin = val;
                    currentMinIndex = i;
                } else if (val < currentSecondMin) {
                    currentSecondMin = val;
                }
            }

            min = currentMin;
            secondMin = currentSecondMin;
            minIndex = currentMinIndex;
        }

        return min;
    }

}

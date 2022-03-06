package _20220306_BestSightseeingPair;

public class Solution {

    public int maxScoreSightseeingPair(int[] values) {
        if (values.length <= 1) {
            return 0;
        }
        int left = values[0];
        int res = 0;
        for (int i = 1; i < values.length; i++) {
            res = Math.max(res, left + values[i] - i);
            left = Math.max(left, values[i] + i);
        }
        return res;
    }

}

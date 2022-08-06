package _20220806_MaxValue;

public class Solution {

    public int max_value(int[] value, int[][] extra_value) {
        int n = (int) Math.pow(2, value.length);
        int[] dp = new int[n + 1];
        int max = 0;

        for (int s = 1; s <= n; s++) {
            if (Integer.bitCount(s) > 5) continue;
            for (int i = 0; i < value.length; i++) {
                int lastState = s & (~(1 << i));
                if (s == lastState) continue;
                int extraValue = getExtraValue(extra_value, lastState, i);
                dp[s] = Math.max(dp[s], dp[lastState] + value[i] + extraValue);
            }
            max = Math.max(max, dp[s]);
        }

        return max;
    }

    private int getExtraValue(int[][] extra_value, int s, int i) {
        int value = 0;
        for (int[] extra : extra_value) {
            if (i == extra[0] && (s & (1 << extra[1])) > 0) {
                value += extra[2];
            }
            if (i == extra[1] && (s & (1 << extra[0])) > 0) {
                value += extra[2];
            }
        }
        return value;
    }

}

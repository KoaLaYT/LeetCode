package _20220524_NumberOfWaysToStayInTheSamePlaceAfterSomeSteps;

public class Solution {

    public int numWays(int steps, int arrLen) {
        long[][] memo = new long[Math.min(arrLen, steps + 1)][steps + 1];
        for (int i = 0; i < Math.min(arrLen, steps + 1); i++) {
            for (int j = 0; j <= steps; j++) {
                memo[i][j] = -1;
            }
        }
        memo[0][0] = 1;
        return (int) numWays(arrLen, 0, steps, memo);
    }

    private long numWays(int arrLen, int pos, int left, long[][] memo) {
        if (pos < 0 || pos >= arrLen) {
            return 0;
        }

        if (memo[pos][left] == -1) {
            long res = 0;
            if (left >= pos) {
                res = numWays(arrLen, pos - 1, left - 1, memo)
                        + numWays(arrLen, pos, left - 1, memo)
                        + numWays(arrLen, pos + 1, left - 1, memo);
            }
            memo[pos][left] = Math.floorMod(res, 1000000007);
        }
        return memo[pos][left];
    }

}

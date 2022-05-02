package _20220502_HandshakesThatDontCross;

public class Solution {

    public int numberOfWays(int numPeople) {
        long[] dp = new long[numPeople / 2 + 1];

        dp[0] = 1;
        for (int i = 1; i <= numPeople / 2; i++) {
            long res = 0;
            for (int j = 0; j < i; j++) {
                res += dp[j] * dp[i - 1 - j];
                res = Math.floorMod(res, 1_000_000_007);
            }
            dp[i] = res;
        }

        return (int) dp[numPeople / 2];
    }

}

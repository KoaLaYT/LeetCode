package _20220521_HandshakesThatDontCross;

public class Solution {

    public int numberOfWays(int numPeople) {
        long[] dp = new long[numPeople + 1];
        dp[0] = 1;

        for (int i = 2; i <= numPeople; i += 2) {
            for (int j = 0; j <= i - 2; j += 2) {
                dp[i] += dp[j] * dp[i - j - 2];
                dp[i] = Math.floorMod(dp[i], 1000000007);
            }
        }

        return (int) dp[numPeople];
    }

}

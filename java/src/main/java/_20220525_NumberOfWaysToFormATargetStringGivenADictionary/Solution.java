package _20220525_NumberOfWaysToFormATargetStringGivenADictionary;

public class Solution {

    private static final int MOD = 1000000007;

    public int numWays(String[] words, String target) {
        int m = words[0].length();
        int n = target.length();

        int[][] cnt = new int[m][26];
        for (int i = 0; i < m; i++) {
            for (String word : words) {
                cnt[i][word.charAt(i) - 'a'] += 1;
            }
        }

        long[][] dp = new long[m][n];
        dp[0][0] = cnt[0][target.charAt(0) - 'a'];

        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.floorMod(dp[i - 1][0] + cnt[i][target.charAt(0) - 'a'], MOD);
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.floorMod(dp[i - 1][j] + dp[i - 1][j - 1] * cnt[i][target.charAt(j) - 'a'], MOD);
            }
        }

        return (int) dp[m - 1][n - 1];
    }

}

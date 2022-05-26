package _20220526_DistinctSubsequencesII;

public class Solution {

    private static final int MOD = 1000000007;

    public int distinctSubseqII(String s) {
        int n = s.length();
        char[] ss = s.toCharArray();
        long[] dp = new long[n];
        boolean[] appeared = new boolean[26];

        dp[n - 1] = 1;
        appeared[ss[n - 1] - 'a'] = true;

        long count = dp[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int pos = ss[i] - 'a';
            if (!appeared[pos]) {
                dp[i] = 1;
                appeared[pos] = true;
            }
            for (int j = i + 1; j < n; j++) {
                dp[i] = (dp[i] + dp[j]) % MOD;
                if (ss[i] == ss[j]) break;
            }
            count = (count + dp[i]) % MOD;
        }

        return (int) count;
    }

}

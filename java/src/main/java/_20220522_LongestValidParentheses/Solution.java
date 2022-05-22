package _20220522_LongestValidParentheses;

public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        char[] ss = s.toCharArray();
        int[] dp = new int[n];

        int max = 0;

        for (int i = 1; i < n; i++) {
            if (ss[i] == '(') continue;

            if (ss[i - 1] == '(') {
                int index = i - 2;
                dp[i] = (index >= 0 ? dp[index] : 0) + 2;
            } else {
                int index = i - dp[i - 1] - 1;
                if (index >= 0 && ss[index] == '(') {
                    dp[i] = dp[i - 1] + 2 + (index >= 1 ? dp[index - 1] : 0);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }

}

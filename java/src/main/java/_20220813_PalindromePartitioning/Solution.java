package _20220813_PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {
        int len = s.length();
        char[] ss = s.toCharArray();
        boolean[][] dp = new boolean[len + 2][len + 2];

        for (int i = 0; i < len + 2; i++) {
            for (int j = 0; j < len + 2; j++) {
                if (i >= j) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = len; i > 0; i--) {
            for (int j = i + 1; j <= len; j++) {
                dp[i][j] = (ss[i - 1] == ss[j - 1]) && dp[i + 1][j - 1];
            }
        }

        List<List<String>> result = new ArrayList<>();
        List<String> tmp = new ArrayList<>(len);
        buildResult(ss, dp, 0, tmp, result);
        return result;
    }

    private void buildResult(
            char[] ss, boolean[][] dp, int i,
            List<String> result, List<List<String>> total
    ) {
        if (i == ss.length) {
            List<String> copy = new ArrayList<>(result);
            total.add(copy);
            return;
        }

        for (int j = i; j < ss.length; j++) {
            if (dp[i + 1][j + 1]) {
                String p = build(ss, i, j);
                result.add(p);
                buildResult(ss, dp, j + 1, result, total);
                result.remove(result.size() - 1);
            }
        }
    }

    private String build(char[] ss, int i, int j) {
        StringBuilder sb = new StringBuilder();
        for (int k = i; k <= j; k++) {
            sb.append(ss[k]);
        }
        return sb.toString();
    }

}

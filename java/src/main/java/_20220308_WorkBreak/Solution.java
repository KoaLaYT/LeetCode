package _20220308_WorkBreak;

import java.util.List;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] memo = new boolean[s.length() + 1];
        return wordBreak(s, 0, wordDict, memo);
    }

    private boolean wordBreak(String s, int i, List<String> wordDict, boolean[] memo) {
        if (memo[s.length()]) {
            return true;
        }
        for (String word : wordDict) {
            int len = word.length();
            if (i + len > s.length() || memo[i + len]) {
                continue;
            }
            if (s.startsWith(word, i)) {
                memo[i + len] = true;
                if (wordBreak(s, i + len, wordDict, memo)) {
                    return true;
                }
            }
        }
        return false;
    }

}

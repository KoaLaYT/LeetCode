package _20220924_LongestSubstringWithAtLeastKRepeatingCharacters;

public class Solution {

    public int longestSubstring(String s, int k) {
        return longestSubstring(s.toCharArray(), k, 0, s.length() - 1);
    }

    private int longestSubstring(char[] ss, int k, int lo, int hi) {
        if (lo > hi) {
            return 0;
        }

        int[] cnt = new int[26];
        for (int i = lo; i <= hi; i++) {
            cnt[ss[i] - 'a'] += 1;
        }

        char split = '\0';
        int maxLtK = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) continue;
            if (cnt[i] >= k) continue;
            if (cnt[i] > maxLtK) {
                maxLtK = cnt[i];
                split = (char) ('a' + i);
            }
        }

        if (split == '\0') {
            return hi - lo + 1;
        }

        int i = lo;
        int max = 0;
        while (i <= hi) {
            while (i <= hi && ss[i] == split) {
                i += 1;
            }
            int start = i;
            while (i <= hi && ss[i] != split) {
                i += 1;
            }
            max = Math.max(max, longestSubstring(ss, k, start, i - 1));
        }
        return max;
    }

}

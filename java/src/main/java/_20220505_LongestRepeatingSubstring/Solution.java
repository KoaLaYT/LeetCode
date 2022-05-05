package _20220505_LongestRepeatingSubstring;

import java.util.HashSet;

public class Solution {

    private static final int BASE = 26;
    private static final long MODULES = (long) Math.pow(2, 24);

    public int longestRepeatingSubstring(String s) {
        int lo = 1;
        int hi = s.length();
        long[] nn = new long[hi];
        for (int i = 0; i < hi; i++) {
            nn[i] = s.charAt(i) - 'a';
        }

        while (lo <= hi) {
            int len = lo + (hi - lo) / 2;
            if (hasRepeat(len, nn)) {
                lo = len + 1;
            } else {
                hi = len - 1;
            }
        }

        return lo - 1;
    }

    private boolean hasRepeat(int len, long[] nn) {
        HashSet<Long> set = new HashSet<>();

        long h = 0;
        for (int i = 0; i < len; i++) {
            h = (h * BASE + nn[i]) % MODULES;
        }
        set.add(h);

        long prefix = 1;
        for (int i = 1; i <= len; i++) {
            prefix = (prefix * BASE) % MODULES;
        }

        for (int i = 1; i + len <= nn.length; i++) {
            h = (h * BASE - nn[i - 1] * prefix % MODULES + MODULES) % MODULES;
            h = (h + nn[i + len - 1]) % MODULES;
            if (set.contains(h)) {
                return true;
            }
            set.add(h);
        }

        return false;
    }

}

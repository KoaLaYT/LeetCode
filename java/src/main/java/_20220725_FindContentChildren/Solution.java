package _20220725_FindContentChildren;

import java.util.Arrays;

public class Solution {

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i += 1;
                j += 1;
                count += 1;
            } else {
                j += 1;
            }
        }

        return count;
    }

}

package _20211005_InterleavingString;

import java.util.Stack;

/**
 * @author koalayt 2021-10-05
 */
public class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] checked = new boolean[s1.length() + 1][s2.length() + 1];
        Stack<Possible> reachable = new Stack<>();
        reachable.push(new Possible(0, 0));

        while (!reachable.isEmpty()) {
            Possible possible = reachable.pop();
            int i = possible.i;
            int j = possible.j;

            if (i + j >= s3.length()) {
                return true;
            }

            if (checked[i][j]) {
                continue;
            }

            char c3 = s3.charAt(i + j);
            if (i < s1.length() && s1.charAt(i) == c3) {
                reachable.push(new Possible(i + 1, j));
            }
            if (j < s2.length() && s2.charAt(j) == c3) {
                reachable.push(new Possible(i, j + 1));
            }

            checked[i][j] = true;
        }

        return false;
    }

    private static class Possible {
        int i;
        int j;

        Possible(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}

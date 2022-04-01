package _20220401_ShortestWayToFormString;

public class Solution {

    public int shortestWay(String source, String target) {
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();

        int i = 0;
        int j = 0;
        boolean hasMatch = false;

        int count = 0;

        while (j < t.length) {
            if (i == s.length) {
                if (!hasMatch) {
                    return -1;
                }
                count++;
                i = 0;
                hasMatch = false;
            }

            if (s[i] == t[j]) {
                hasMatch = true;
                i++;
                j++;
            } else {
                i++;
            }
        }

        return count + 1;
    }

}

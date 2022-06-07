package _20220607_FindPermutation;

public class Solution {

    public int[] findPermutation(String s) {
        int i = 1;
        int j = 1;

        char[] ss = new char[s.length() + 1];
        for (int k = 0; k < s.length(); k++) {
            ss[k] = s.charAt(k);
        }
        ss[s.length()] = 'I';

        int[] res = new int[s.length() + 1];
        int p = 0;

        for (char c : ss) {
            if (c == 'D') {
                i++;
            } else {
                for (int k = i; k >= j; k--) {
                    res[p++] = k;
                }
                i += 1;
                j = i;
            }
        }

        return res;
    }

}

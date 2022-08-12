package _20220812_ValidPalindrome;

public class Solution {

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] ss = s.toCharArray();

        while (i < j) {
            if (noneAlphanumeric(ss[i])) {
                i++;
                continue;
            }
            if (noneAlphanumeric(ss[j])) {
                j--;
                continue;
            }

            char ii = ss[i];
            char jj = ss[j];
            int v1 = isUpperCase(ii) ? ii - 'A' : ii - 'a';
            int v2 = isUpperCase(jj) ? jj - 'A' : jj - 'a';
            if (v1 != v2) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    private boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private boolean noneAlphanumeric(char c) {
        if (c >= 'a' && c <= 'z') {
            return false;
        }
        if (c >= 'A' && c <= 'Z') {
            return false;
        }
        if (c >= '0' && c <= '9') {
            return false;
        }
        return true;
    }

}

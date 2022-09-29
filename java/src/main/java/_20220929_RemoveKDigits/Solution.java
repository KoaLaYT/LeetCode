package _20220929_RemoveKDigits;

public class Solution {

    public String removeKdigits(String num, int k) {
        char[] cc = num.toCharArray();

        int i = 0, j = 1;
        while (k > 0 && j < cc.length) {
            if (cc[i] > cc[j]) {
                cc[i] = '\0';
                k -= 1;
                while (i >= 0 && cc[i] == '\0') {
                    i -= 1;
                }
                if (i == -1) {
                    i = j;
                    j += 1;
                }
            } else {
                i = j;
                j += 1;
            }
        }

        i = cc.length - 1;
        while (k > 0) {
            if (cc[i] != '\0') {
                cc[i] = '\0';
                k -= 1;
            }
            i -= 1;
        }

        StringBuilder sb = new StringBuilder();
        i = 0;
        while (i < cc.length && (cc[i] == '\0' || cc[i] == '0')) {
            i++;
        }

        while (i < cc.length) {
            if (cc[i] != '\0') {
                sb.append(cc[i]);
            }
            i++;
        }

        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }

}

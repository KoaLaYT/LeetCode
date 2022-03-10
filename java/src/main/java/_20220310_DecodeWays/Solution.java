package _20220310_DecodeWays;

public class Solution {

    public int numDecodings(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        if (s.charAt(0) == '0') {
            return 0;
        }

        int pre = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            int tmp = cur;
            char digit = s.charAt(i);
            char preDigit = s.charAt(i - 1);
            if (digit == '0') {
                if (preDigit == '1' || preDigit == '2') {
                    cur = pre;
                } else {
                    return 0;
                }
            } else if (preDigit == '1' || (preDigit == '2' && digit <= '6')) {
                cur += pre;
            }
            pre = tmp;
        }
        return cur;
    }
}

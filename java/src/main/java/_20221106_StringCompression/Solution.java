package _20221106_StringCompression;

public class Solution {

    public int compress(char[] chars) {
        int len = 1;
        char c = chars[0];
        int p = 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == c) {
                len++;
            } else {
                p = write(chars, c, len, p);
                c = chars[i];
                len = 1;
            }
        }

        return write(chars, c, len, p);
    }

    private int write(char[] chars, char c, int len, int pos) {
        chars[pos++] = c;
        if (len > 1) {
            char[] digits = convert(len);
            for (char digit : digits) {
                chars[pos++] = digit;
            }
        }
        return pos;
    }

    private char[] convert(int digit) {
        int len = 1;

        int rem = digit / 10;
        while (rem > 0) {
            rem /= 10;
            len += 1;
        }

        char[] result = new char[len];
        for (int i = len - 1; i >= 0; i--) {
            result[i] = (char) ((digit % 10) + '0');
            digit /= 10;
        }

        return result;
    }

}

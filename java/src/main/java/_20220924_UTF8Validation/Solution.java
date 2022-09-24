package _20220924_UTF8Validation;

public class Solution {

    public boolean validUtf8(int[] data) {
        int i = 0;

        while (i < data.length) {
            int c = data[i];
            if (c >> 7 == 0) {
                i += 1;
            } else if (c >> 5 == 0b110) {
                if (isInvalidFollowingBytes(data, i + 1, 1)) {
                    return false;
                }
                i += 2;
            } else if (c >> 4 == 0b1110) {
                if (isInvalidFollowingBytes(data, i + 1, 2)) {
                    return false;
                }
                i += 3;
            } else if (c >> 3 == 0b11110) {
                if (isInvalidFollowingBytes(data, i + 1, 3)) {
                    return false;
                }
                i += 4;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isInvalidFollowingBytes(int[] data, int start, int len) {
        for (int i = 0; i < len; i++) {
            if (start + i >= data.length) {
                return true;
            }

            int c = data[start + i];
            if ((c >> 6) != 0b10) {
                return true;
            }
        }

        return false;
    }

}

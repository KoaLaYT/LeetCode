package _20220828_AdditiveNumber;

public class Solution {

    public boolean isAdditiveNumber(String num) {
        if (num.length() <= 2) {
            return false;
        }

        char[] digits = num.toCharArray();

        if (digits[0] == '0' && digits[1] == '0') {
            return isAllZeros(digits, 2);
        }

        if (digits[0] == '0') {
            for (int j = 1; j + 1 < digits.length; j++) {
                int first = 0;
                long second = getNumber(digits, 1, j);
                if (isAdditiveNumber(digits, j + 1, first, second)) {
                    return true;
                }
            }
            return false;
        }

        for (int i = 0; i + 1 < digits.length; i++) {
            if (digits[i + 1] == '0') {
                long first = getNumber(digits, 0, i);
                int second = 0;
                if (i + 2 < digits.length && isAdditiveNumber(digits, i + 2, first, second)) {
                    return true;
                }
                continue;
            }
            for (int j = i + 1; j + 1 < digits.length; j++) {
                long first = getNumber(digits, 0, i);
                long second = getNumber(digits, i + 1, j);
                if (isAdditiveNumber(digits, j + 1, first, second)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isAllZeros(char[] digits, int index) {
        while (index < digits.length) {
            if (digits[index] != '0') {
                return false;
            }
            index += 1;
        }
        return true;
    }

    private boolean isAdditiveNumber(char[] digits, int index, long first, long second) {
        if (index == digits.length) {
            return true;
        }

        if (index > digits.length || digits[index] == '0') {
            return false;
        }

        long target = first + second;
        int nextIndex = findNumber(digits, index, target);
        if (nextIndex > 0) {
            return isAdditiveNumber(digits, nextIndex, second, target);
        }
        return false;
    }

    private int findNumber(char[] digits, int index, long target) {
        int len = findLen(target);
        long base = (long) Math.pow(10, len - 1);

        if (index + len > digits.length) {
            return -1;
        }

        while (base > 0) {
            int targetDigit = (int) (target / base);

            if (digits[index] - '0' != targetDigit) {
                return -1;
            }

            target = target % base;
            base /= 10;
            index += 1;
        }

        return index;
    }

    private int findLen(long number) {
        int len = 1;
        while (number >= 10) {
            number /= 10;
            len += 1;
        }
        return len;
    }

    private long getNumber(char[] digits, int start, int end) {
        long num = 0;
        for (int i = start; i <= end; i++) {
            num = 10 * num + (digits[i] - '0');
        }
        return num;
    }

}

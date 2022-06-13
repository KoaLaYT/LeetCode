package _20220613_AddMinimalBrackets;

public class Solution {

    public int addMinimalBrackets(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        int left = 0;
        int addNum = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left += 1;
            } else if (left > 0) {
                left -= 1;
            } else {
                addNum += 1;
            }
        }

        return left + addNum;
    }

}

package _20220614_BasicCalculator;

import java.util.Stack;

public class Solution {

    public int calculate(String s) {
        Stack<Integer> ops = new Stack<>();
        ops.push(1);
        int sign = 1;

        int result = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
            } else if (c == '+') {
                sign = ops.peek();
                i++;
            } else if (c == '-') {
                sign = -ops.peek();
                i++;
            } else if (c == '(') {
                ops.push(sign);
                i++;
            } else if (c == ')') {
                ops.pop();
                i++;
            } else {
                int num = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = 10 * num + (s.charAt(i) - '0');
                    i++;
                }
                result += sign * num;
            }
        }

        return result;

    }

}

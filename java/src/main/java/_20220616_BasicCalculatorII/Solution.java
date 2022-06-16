package _20220616_BasicCalculatorII;

import java.util.Stack;

public class Solution {

    public int calculate(String s) {
        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);

            if (c == ' ') {
                i++;
                continue;
            }

            if (c == '+') {
                while (!ops.empty()) {
                    doOp(ops, nums);
                }
                ops.push(c);
                i++;
            } else if (c == '-') {
                if (nums.empty()) {
                    nums.push(0);
                } else {
                    while (!ops.empty()) {
                        doOp(ops, nums);
                    }
                }
                ops.push(c);
                i++;
            } else if (c == '*' || c == '/') {
                if (!ops.empty() && ops.peek() != '+' && ops.peek() != '-') {
                    doOp(ops, nums);
                }
                ops.push(c);
                i++;
            } else {
                int num = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = 10 * num + (s.charAt(i) - '0');
                    i++;
                }
                nums.push(num);
            }
        }

        while (!ops.empty()) {
            doOp(ops, nums);
        }

        return nums.peek();
    }

    private int doOp(char op, int a, int b) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            return a / b;
        }
    }

    private void doOp(Stack<Character> ops, Stack<Integer> nums) {
        char op = ops.pop();
        int b = nums.pop();
        int a = nums.pop();
        nums.push(doOp(op, a, b));
    }

}

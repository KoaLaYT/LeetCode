package _20220613_ScoreOfParentheses;

import java.util.Stack;

public class Solution {

    public int scoreOfParentheses(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int score = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int top = stack.pop();
                int add = top == 0 ? 1 : top * 2;
                if (stack.empty()) {
                    score += add;
                } else {
                    stack.push(stack.pop() + add);
                }
            }
        }

        return score;
    }

}

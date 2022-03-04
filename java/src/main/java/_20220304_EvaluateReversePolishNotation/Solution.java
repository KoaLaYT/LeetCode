package _20220304_EvaluateReversePolishNotation;

public class Solution {

    public int evalRPN(String[] tokens) {
        int[] stack = new int[(tokens.length + 1) / 2];
        int index = -1;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    index--;
                    stack[index] += stack[index + 1];
                    break;
                case "-":
                    index--;
                    stack[index] -= stack[index + 1];
                    break;
                case "*":
                    index--;
                    stack[index] *= stack[index + 1];
                    break;
                case "/":
                    index--;
                    stack[index] /= stack[index + 1];
                    break;
                default:
                    stack[++index] = Integer.parseInt(token);
                    break;
            }
        }
        return stack[0];
    }

}

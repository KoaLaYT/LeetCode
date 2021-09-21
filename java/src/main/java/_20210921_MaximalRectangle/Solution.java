package _20210921_MaximalRectangle;

import java.util.Stack;

/**
 * @author koalayt 2021-09-21
 */
public class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return 0;
        }

        int max = 0;
        int[] histogram = new int[matrix[0].length];

        for (char[] chars : matrix) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '1') {
                    histogram[j] += 1;
                } else {
                    histogram[j] = 0;
                }
            }
            max = Math.max(max, maximalHistogram(histogram));
        }
        return max;
    }

    private int maximalHistogram(int[] histogram) {
        int max = 0;
        int len = histogram.length;

        int[] left = new int[len];
        int[] right = new int[len];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = 0;
            } else {
                left[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = len - 1;
            } else {
                right[i] = stack.peek() - 1;
            }
            stack.push(i);
        }

        for (int i = 0; i < len; i++) {
            max = Math.max(max, (right[i] - left[i] + 1) * histogram[i]);
        }

        return max;
    }

}

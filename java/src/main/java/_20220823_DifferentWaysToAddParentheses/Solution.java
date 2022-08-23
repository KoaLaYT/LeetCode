package _20220823_DifferentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Solution {

  public List<Integer> diffWaysToCompute(String expression) {
    List<Integer> nums = new ArrayList<>();
    List<Character> ops = new ArrayList<>();

    int num = 0;
    for (char c : expression.toCharArray()) {
      if (c == '+' || c == '-' || c == '*') {
        ops.add(c);
        nums.add(num);
        num = 0;
      } else {
        int digit = c - '0';
        num = 10 * num + digit;
      }
    }
    nums.add(num);

    Map<Range, List<Integer>> memo = new HashMap<>();
    return compute(nums, ops, 0, nums.size() - 1, memo);
  }

  private List<Integer> compute(
      List<Integer> nums,
      List<Character> ops,
      int i, int j,
      Map<Range, List<Integer>> memo
  ) {
    if (i == j) {
      return Collections.singletonList(nums.get(i));
    }

    Range range = new Range(i, j);
    if (memo.containsKey(range)) {
      return memo.get(range);
    }

    List<Integer> result = new ArrayList<>();
    for (int k = i; k + 1 <= j; k++) {
      List<Integer> res1 = compute(nums, ops, i, k, memo);
      List<Integer> res2 = compute(nums, ops, k + 1, j, memo);
      char op = ops.get(k);
      for (int a : res1) {
        for (int b : res2) {
          result.add(doOp(op, a, b));
        }
      }
    }
    memo.put(range, result);
    return result;
  }

  private int doOp(char op, int a, int b) {
    switch (op) {
      case '+':
        return a + b;
      case '-':
        return a - b;
      case '*':
        return a * b;
    }
    throw new RuntimeException("unknown operation");
  }

  private static class Range {

    int i;
    int j;

    Range(int i, int j) {
      this.i = i;
      this.j = j;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Range range = (Range) o;
      return i == range.i && j == range.j;
    }

    @Override
    public int hashCode() {
      return Objects.hash(i, j);
    }
  }

}

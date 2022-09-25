package _20220925_IntegerReplacement;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int integerReplacement(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return integerReplacement(n, memo);
    }

    private int integerReplacement(int n, Map<Integer, Integer> memo) {
        if (n == 1) {
            return 0;
        }

        if (!memo.containsKey(n)) {
            if (n % 2 == 0) {
                memo.put(n, 1 + integerReplacement(n / 2, memo));
            } else {
                int v1 = integerReplacement(n / 2, memo);
                int v2 = integerReplacement(n / 2 + 1, memo);
                memo.put(n, 2 + Math.min(v1, v2));
            }
        }

        return memo.get(n);
    }

}

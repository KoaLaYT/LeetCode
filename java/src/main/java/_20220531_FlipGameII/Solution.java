package _20220531_FlipGameII;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean canWin(String currentState) {
        Map<String, Boolean> memo = new HashMap<>();

        return canWin(currentState, memo);
    }

    public boolean canWin(String state, Map<String, Boolean> memo) {
        if (!memo.containsKey(state)) {
            boolean canWin = false;

            for (int i = 0; i < state.length() - 1; i++) {
                if (state.charAt(i) == '+' && state.charAt(i + 1) == '+') {
                    char[] ss = state.toCharArray();
                    ss[i] = '-';
                    ss[i + 1] = '-';
                    canWin |= !canWin(new String(ss), memo);
                }
            }

            memo.put(state, canWin);
        }

        return memo.get(state);
    }

}

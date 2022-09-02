package _20220902_RemoveDuplicateLetters;

import java.util.*;

public class Solution {

    public String removeDuplicateLetters(String s) {
        char[] cc = s.toCharArray();

        int[] cnt = new int[26];
        for (char c : cc) {
            cnt[c - 'a'] += 1;
        }

        Deque<Character> stack = new ArrayDeque<>();
        boolean[] added = new boolean[26];

        for (char c : cc) {
            if (added[c - 'a']) {
                cnt[c - 'a'] -= 1;
                continue;
            }
            while (!stack.isEmpty()) {
                char top = stack.peek();
                if ((top <= c) || cnt[top - 'a'] == 0) {
                    break;
                }
                stack.pop();
                added[top - 'a'] = false;
            }
            stack.push(c);
            added[c - 'a'] = true;
            cnt[c - 'a'] -= 1;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

}

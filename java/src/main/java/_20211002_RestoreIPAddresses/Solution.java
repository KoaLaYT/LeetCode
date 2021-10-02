package _20211002_RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author koalayt 2021-10-02
 */
public class Solution {

    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        restoreIpAddresses(s, 0, 4, sb, result);
        return result;
    }

    public void restoreIpAddresses(String s, int index, int left, StringBuilder sb, List<String> result) {
        if (index >= s.length()) {
            return;
        }

        // fast return
        // 1. too short left strings
        if (s.length() - index < left) {
            return;
        }
        // 2. too many left strings
        if (s.length() - index > 3 * left) {
            return;
        }

        if (left == 1) {
            if (s.length() - index > 3) {
                return;
            }
            String last = s.substring(index);
            if (last.length() > 1 && s.charAt(index) == '0') {
                return;
            }
            if (last.length() < 3 || Integer.parseInt(last) <= 255) {
                int start = sb.length();
                sb.append('.');
                sb.append(last);
                result.add(sb.toString());
                sb.delete(start, start + last.length() + 1);
            }
            return;
        }

        int length;
        if (s.charAt(index) == '0') {
            length = 1;
        } else {
            length = Math.min(s.length(), index + 3) - index;
        }

        while (length > 0) {
            String next = s.substring(index, index + length);
            if (length < 3 || Integer.parseInt(next) <= 255) {
                int start = sb.length();
                if (start > 0) {
                    sb.append('.');
                }
                sb.append(next);
                restoreIpAddresses(s, index + length, left - 1, sb, result);
                sb.delete(start, start + length + 1);
            }
            length -= 1;
        }
    }

}

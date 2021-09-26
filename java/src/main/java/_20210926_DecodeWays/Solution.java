package _20210926_DecodeWays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author koalayt 2021-09-26
 */
public class Solution {

    public int numDecodings(String s) {
        return numDecodings(s, 0, new HashMap<>());
    }

    private int numDecodings(String s, int index, Map<Integer, Integer> memorized) {
        if (index < s.length() && s.charAt(index) == '0') {
            return 0;
        }

        if (index >= s.length() - 1) {
            return 1;
        }

        if (memorized.containsKey(index)) {
            return memorized.get(index);
        }

        if (Integer.parseInt(s.substring(index, index + 2)) > 26) {
            return numDecodings(s, index + 1, memorized);
        }

        int sum = numDecodings(s, index + 2, memorized) + numDecodings(s, index + 1, memorized);
        memorized.put(index, sum);
        return sum;
    }

}

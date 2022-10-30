package _20221030_FindAllAnagramsInAString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();

        if (pLen > s.length()) {
            return Collections.emptyList();
        }

        int[] cnts = buildCnts(p);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a'] -= 1;
            if (i - pLen >= 0) {
                cnts[s.charAt(i - pLen) - 'a'] += 1;
            }

            if (isAllZero(cnts)) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }

    private int[] buildCnts(String p) {
        int[] cnts = new int[26];
        for (int i = 0; i < p.length(); i++) {
            cnts[p.charAt(i) - 'a'] += 1;
        }
        return cnts;
    }

    private boolean isAllZero(int[] cnts) {
        for (int cnt : cnts) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }

}

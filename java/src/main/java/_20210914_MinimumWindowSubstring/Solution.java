package _20210914_MinimumWindowSubstring;

/**
 * @author koalayt 2021-09-14
 */
public class Solution {

    public String minWindow(String s, String t) {
        if (s.length() <= 0) return "";

        int start = 0;
        int end = -1;
        int i = 0;
        int j = -1;
        WindowChecker checker = new WindowChecker(t);
        while (true) {
            if (checker.includes()) {
                if (end < 0 || j - i < end - start) {
                    start = i;
                    end = j;
                }
                checker.contract(s.charAt(i++));
            } else if (j < s.length() - 1) {
                checker.expand(s.charAt(++j));
            } else {
                break;
            }
        }
        return s.substring(start, end + 1);
    }

    static class WindowChecker {
        private static final int SIZE = 'z' - 'A' + 1;
        private static final int A_INDEX = 'A';

        int[] charCount;
        int[] charIndexMap;
        int count;

        WindowChecker(String t) {
            charIndexMap = new int[SIZE];

            int order = 1;
            for (int i = 0; i < t.length(); i++) {
                int index = t.charAt(i) - A_INDEX;
                if (charIndexMap[index] == 0) {
                    charIndexMap[index] = order++;
                }
            }

            charCount = new int[order - 1];
            count = t.length();
            for (int i = 0; i < t.length(); i++) {
                charCount[getIndex(t.charAt(i))]++;
            }
        }

        private int getIndex(char c) {
            return charIndexMap[((int) c) - A_INDEX] - 1;
        }

        boolean includes() {
            return count == 0;
        }

        void contract(char c) {
            int index = getIndex(c);
            if (index == -1) return;
            int v = charCount[index];
            if (v >= 0) {
                count += 1;
            }
            charCount[index]++;

        }

        void expand(char c) {
            int index = getIndex(c);
            if (index == -1) return;
            int v = charCount[index];
            if (v > 0) {
                count -= 1;
            }
            charCount[index]--;
        }
    }

}

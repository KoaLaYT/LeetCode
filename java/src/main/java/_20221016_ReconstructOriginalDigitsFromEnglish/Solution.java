package _20221016_ReconstructOriginalDigitsFromEnglish;

public class Solution {

    private static final int DIGIT_NUM = 10;

    private static final char[] ORDER_CHAR = new char[]{
            'z', 'x', 'g', 'h', 'r', 'f', 'v', 'w', 'o', 'i'
    };

    private static final int[] ORDER_DIGIT = new int[]{
            0, 6, 8, 3, 4, 5, 7, 2, 1, 9
    };

    private static final char[][] DIGIT_CHAR = new char[][]{
            {'z', 'e', 'r', 'o'},
            {'o', 'n', 'e'},
            {'t', 'w', 'o'},
            {'t', 'h', 'r', 'e', 'e'},
            {'f', 'o', 'u', 'r'},
            {'f', 'i', 'v', 'e'},
            {'s', 'i', 'x'},
            {'s', 'e', 'v', 'e', 'n'},
            {'e', 'i', 'g', 'h', 't'},
            {'n', 'i', 'n', 'e'}
    };

    public String originalDigits(String s) {
        int[] charCnts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCnts[c - 'a'] += 1;
        }

        int[] nums = new int[DIGIT_NUM];

        for (int i = 0; i < DIGIT_NUM; i++) {
            char c = ORDER_CHAR[i];
            int d = ORDER_DIGIT[i];

            int cnts = charCnts[c - 'a'];
            nums[d] += cnts;

            char[] digitChars = DIGIT_CHAR[d];
            for (int n = 0; n < cnts; n++) {
                for (char dc : digitChars) {
                    charCnts[dc - 'a'] -= 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < DIGIT_NUM; i++) {
            while (nums[i] > 0) {
                sb.append(i);
                nums[i] -= 1;
            }
        }

        return sb.toString();
    }

}

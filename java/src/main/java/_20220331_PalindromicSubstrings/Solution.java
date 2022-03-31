package _20220331_PalindromicSubstrings;

public class Solution {

    public int countSubstrings(String s) {
        char[] cc = s.toCharArray();

        int count = 0;
        for (int i = 0; i < cc.length; i++) {
            count += checkPalindromic(cc, i, i);
            count += checkPalindromic(cc, i, i + 1);
        }

        return count;
    }

    private int checkPalindromic(char[] cc, int start, int end) {
        int count = 0;
        while (start >= 0 && end < cc.length) {
            if (cc[start] != cc[end]) {
                break;
            }
            count++;
            start--;
            end++;
        }
        return count;
    }

}

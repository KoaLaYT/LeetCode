package _20220316_LongestPalindromicSubstring;

public class Solution {

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int start = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            int len_odd = expandAroundCenter(s, i, i);
            int len_even = expandAroundCenter(s, i, i + 1);

            if (len_odd > len) {
                start = i - len_odd / 2;
                len = len_odd;
            }

            if (len_even > len) {
                start = i - len_even / 2 + 1;
                len = len_even;
            }
        }

        return s.substring(start, start + len);
    }

    private int expandAroundCenter(String s, int i, int j) {
        int len = 0;
        while (i >= 0 && j <= s.length() - 1) {
            if (s.charAt(i) == s.charAt(j)) {
                len = j - i + 1;
                i--;
                j++;
            } else {
                break;
            }
        }
        return len;
    }

}

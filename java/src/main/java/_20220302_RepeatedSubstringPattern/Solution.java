package _20220302_RepeatedSubstringPattern;

public class Solution {

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i == 0) {
                if (isRepeatedSubstring(s, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isRepeatedSubstring(String s, int substringLen) {
        for (int i = substringLen; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - substringLen)) {
                return false;
            }
        }
        return true;
    }

}

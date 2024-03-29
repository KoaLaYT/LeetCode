package _20220728_IsAnagram;

public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] cnt = new int[26];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            cnt[ss[i] - 'a'] += 1;
            cnt[tt[i] - 'a'] -= 1;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                return false;
            }
        }

        return true;
    }

}

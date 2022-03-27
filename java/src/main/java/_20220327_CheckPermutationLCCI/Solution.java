package _20220327_CheckPermutationLCCI;

public class Solution {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 == null || s2 == null) {
            return false;
        }

        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 != len2) {
            return false;
        }

        int[] memo = new int[26];

        for (int i = 0; i < len1; i++) {
            int index = s1.charAt(i) - 'a';
            memo[index] += 1;
        }

        for (int i = 0; i < len2; i++) {
            int index = s2.charAt(i) - 'a';
            memo[index] -= 1;
        }

        for (int i = 0; i < 26; i++) {
            if (memo[i] != 0) {
                return false;
            }
        }

        return true;
    }

}

package _20220327_IsUniqueLCCI;

public class Solution {

    public boolean isUnique(String astr) {
        char[] cc = astr.toCharArray();
        boolean[] memo = new boolean[26];

        for (char c : cc) {
            int index = c - 'a';
            if (memo[index]) {
                return false;
            }
            memo[index] = true;
        }

        return true;
    }

}

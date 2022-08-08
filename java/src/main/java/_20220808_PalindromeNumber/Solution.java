package _20220808_PalindromeNumber;

public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        return x == reverse(x);
    }

    private long reverse(long x) {
        long res = 0;
        while (x > 0) {
            long left = x / 10;
            long digit = x - left * 10;
            res = 10 * res + digit;
            x = left;
        }
        return res;
    }

}

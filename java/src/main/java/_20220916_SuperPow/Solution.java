package _20220916_SuperPow;

public class Solution {

    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int res = 1;

        for (int e : b) {
            res = myPow(res, 10) * myPow(a, e) % MOD;
        }

        return res;
    }

    private static int myPow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }
        return res;
    }

}

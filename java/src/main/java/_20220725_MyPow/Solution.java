package _20220725_MyPow;

public class Solution {

    public double myPow(double x, int n) {
        return myPow(x, (long) n);
    }

    private double myPow(double x, long n) {
        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n % 2 == 1) {
            return x * myPow(x, n - 1);
        } else {
            double result = myPow(x, n / 2);
            return result * result;
        }
    }

}

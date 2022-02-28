package _20220228_FibonacciNumber;

public class Solution {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }

        int a = 1;
        int b = 1;
        for (int i = 3; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return a + b;
    }

}

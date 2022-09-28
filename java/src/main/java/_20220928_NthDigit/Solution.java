package _20220928_NthDigit;

public class Solution {

    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }

        long preLimit = 1;
        long limit = 10;
        long base = 10;
        int k = 1;

        while (n >= limit) {
            k += 1;
            preLimit = limit;
            limit = (base * 10 - 1 - base) * k + preLimit + k;
            base *= 10;
        }

        long pos = (n - preLimit) % k;
        long find = n - pos;
        long num = (find - preLimit) / k + base / 10;

        String numStr = String.valueOf(num);

        return numStr.charAt((int) pos) - '0';
    }

}

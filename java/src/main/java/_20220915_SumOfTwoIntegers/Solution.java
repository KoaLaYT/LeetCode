package _20220915_SumOfTwoIntegers;

public class Solution {

    public int getSum(int a, int b) {
        int sum = 0;
        int shift = 0;

        for (int i = 0; i < 32; i++) {
            int d1 = (a >> i) & 1;
            int d2 = (b >> i) & 1;

            int s = d1 ^ d2 ^ shift;

            int ones = 0;
            if (d1 == 1) {
                ones += 1;
            }
            if (d2 == 1) {
                ones += 1;
            }
            if (shift == 1) {
                ones += 1;
            }

            if (ones >= 2) {
                shift = 1;
            } else {
                shift = 0;
            }

            sum |= (s << i);
        }

        if (shift == 1) {
            sum &= (-1);
        }

        return sum;
    }

}

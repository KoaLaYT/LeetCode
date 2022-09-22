package _20220922_EliminationGame;

public class Solution {

    public int lastRemaining(int n) {
        int step = 1;
        int k = 0;
        int count = n;
        int start = 1;

        while (count > 1) {
            if (k % 2 == 0) {
                start += step;
            } else {
                start += count % 2 == 1 ? step : 0;
            }

            count >>= 1;
            step <<= 1;
            k += 1;
        }

        return start;
    }

}

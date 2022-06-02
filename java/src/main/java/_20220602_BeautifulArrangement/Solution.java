package _20220602_BeautifulArrangement;

public class Solution {

    public int countArrangement(int n) {
        boolean[] used = new boolean[n + 1];
        return countArrangement(n, n, used);
    }

    public int countArrangement(int n, int i, boolean[] used) {
        if (i == 0) {
            return 1;
        }

        int count = 0;

        for (int j = 1; j <= n; j++) {
            if (used[j]) continue;
            if (i % j == 0 || j % i == 0) {
                used[j] = true;
                count += countArrangement(n, i - 1, used);
                used[j] = false;
            }
        }

        return count;

    }

}

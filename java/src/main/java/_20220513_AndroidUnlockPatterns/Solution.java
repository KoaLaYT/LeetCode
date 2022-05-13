package _20220513_AndroidUnlockPatterns;

public class Solution {

    private final int[][] skip = new int[10][10];

    {
        skip[1][3] = 2;
        skip[3][1] = 2;

        skip[1][7] = 4;
        skip[7][1] = 4;

        skip[3][9] = 6;
        skip[9][3] = 6;

        skip[7][9] = 8;
        skip[9][7] = 8;

        skip[1][9] = 5;
        skip[9][1] = 5;
        skip[3][7] = 5;
        skip[7][3] = 5;

        skip[2][8] = 5;
        skip[8][2] = 5;

        skip[4][6] = 5;
        skip[6][4] = 5;
    }

    public int numberOfPatterns(int m, int n) {
        boolean[] used = new boolean[10];
        int sum = 0;
        for (int len = m; len <= n; len++) {
            sum += numberOfPatterns(used, 0, 1, len) * 4;
            sum += numberOfPatterns(used, 0, 2, len) * 4;
            sum += numberOfPatterns(used, 0, 5, len);
        }
        return sum;
    }

    private int numberOfPatterns(boolean[] used, int last, int curr, int len) {
        if (!isValid(used, last, curr)) {
            return 0;
        }

        if (len == 1) {
            return 1;
        }

        int sum = 0;
        used[curr] = true;
        for (int i = 1; i <= 9; i++) {
            sum += numberOfPatterns(used, curr, i, len - 1);
        }
        used[curr] = false;

        return sum;
    }

    private boolean isValid(boolean[] used, int last, int curr) {
        if (used[curr]) {
            return false;
        }
        int cross = skip[last][curr];
        return cross <= 0 || used[cross];
    }

}

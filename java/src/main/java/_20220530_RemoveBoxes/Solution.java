package _20220530_RemoveBoxes;

public class Solution {

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] memo = new int[n][n][n + 1];
        return removeBoxes(boxes, memo, 0, n - 1, 0);
    }

    private int removeBoxes(int[] boxes, int[][][] memo, int l, int r, int k) {
        if (l > r) {
            return 0;
        }

        if (memo[l][r][k] == 0) {
            int r1 = r, k1 = k;

            while (l < r1 && boxes[r1] == boxes[r1 - 1]) {
                r1 -= 1;
                k1 += 1;
            }

            memo[l][r][k] = removeBoxes(boxes, memo, l, r1 - 1, 0) + (k1 + 1) * (k1 + 1);

            for (int i = r1 - 1; i >= l; i--) {
                if (boxes[i] == boxes[r1]) {
                    memo[l][r][k] = Math.max(memo[l][r][k],
                                             removeBoxes(boxes, memo, l, i, k1 + 1) + removeBoxes(boxes, memo, i + 1, r1 - 1, 0));
                }
            }
        }

        return memo[l][r][k];
    }

}

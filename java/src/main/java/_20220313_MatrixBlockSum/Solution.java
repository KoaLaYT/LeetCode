package _20220313_MatrixBlockSum;

public class Solution {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        if (m <= 0) {
            return null;
        }

        int n = mat[0].length;
        if (n <= 0) {
            return null;
        }

        int[][] acc = new int[m][];

        for (int i = 0; i < m; i++) {
            acc[i] = new int[n];
            for (int j = 0; j < n; j++) {
                int sum = mat[i][j];
                if (i - 1 >= 0) {
                    sum += acc[i - 1][j];
                }
                if (j - 1 >= 0) {
                    sum += acc[i][j - 1];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    sum -= acc[i - 1][j - 1];
                }
                acc[i][j] = sum;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int bottom = Math.min(i + k, m - 1);
                int right = Math.min(j + k, n - 1);
                int sum = acc[bottom][right];
                if (j - k - 1 >= 0) {
                    sum -= acc[bottom][j - k - 1];
                }
                if (i - k - 1 >= 0) {
                    sum -= acc[i - k - 1][right];
                }
                if (j - k - 1 >= 0 && i - k - 1 >= 0) {
                    sum += acc[i - k - 1][j - k - 1];
                }
                mat[i][j] = sum;
            }
        }

        return mat;
    }

}

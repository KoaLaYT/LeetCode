package _20210912_SetMatrixZeroes;

/**
 * @author koalayt 2021-09-12
 */
public class Solution {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m <= 0) return;

        int n = matrix[0].length;
        if (n <= 0) return;

        boolean isFirstColumnMarked = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isFirstColumnMarked = true;
                break;
            }
        }

        boolean isFirstRowMarked = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowMarked = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isFirstColumnMarked) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (isFirstRowMarked) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

}

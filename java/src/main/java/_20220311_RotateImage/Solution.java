package _20220311_RotateImage;

public class Solution {

    public void rotate(int[][] matrix) {
        int size = matrix.length;
        int level = 0;
        while (size - 2 * level > 1) {
            // rotate upper row
            for (int j = level; j < size - level - 1; j++) {
                rotate(matrix, level, j, size);
            }
            // rotate left column
            for (int i = size - level - 1; i > level; i--) {
                rotate(matrix, i, level, size);
            }
            // rotate bottom row
            for (int j = size - level - 1; j > level; j--) {
                rotate(matrix, size - level - 1, j, size);
            }

            level += 1;
        }
    }

    private void rotate(int[][] matrix, int i, int j, int n) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][n - i - 1];
        matrix[j][n - i - 1] = temp;
    }

}

package _20220612_SearchMatrix;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }

        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0 && j < matrix[0].length) {
            int current = matrix[i][j];
            if (current == target) {
                return true;
            } else if (current < target) {
                j += 1;
            } else {
                i -= 1;
            }
        }

        return false;
    }

}

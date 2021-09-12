package _20210912_SearchA2DMatrix;

/**
 * @author koalayt 2021-09-12
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length <= 0 || matrix[0].length <= 0) return false;

        int row = findPossibleRow(matrix, target);
        if (row == -1) {
            return true;
        }
        if (row >= matrix.length) {
            return false;
        }
        return findInRow(matrix[row], target);
    }

    private int findPossibleRow(int[][] matrix, int target) {
        int col = matrix[0].length - 1;

        int lo = 0;
        int hi = matrix.length - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (matrix[mi][col] == target) {
                return -1; // means find it
            } else if (matrix[mi][col] < target) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }

        return Math.max(lo, 0);
    }

    private boolean findInRow(int[] row, int target) {
        int lo = 0;
        int hi = row.length - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (row[mi] == target) {
                return true;
            } else if (row[mi] < target) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }
        return false;
    }

}

package _20220313_RangeSumQuery2DImmutable;

class NumMatrix {

    private int[][] acc;

    public NumMatrix(int[][] matrix) {
        buildAcc(matrix);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = acc[row2][col2];
        if (col1 - 1 >= 0) {
            sum -= acc[row2][col1 - 1];
        }
        if (row1 - 1 >= 0) {
            sum -= acc[row1 - 1][col2];
        }
        if (col1 - 1 >= 0 && row1 - 1 >= 0) {
            sum += acc[row1 - 1][col1 - 1];
        }
        return sum;
    }

    private void buildAcc(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        acc = new int[m][];

        for (int i = 0; i < m; i++) {
            acc[i] = new int[n];
            for (int j = 0; j < n; j++) {
                int sum = matrix[i][j];
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
    }

}

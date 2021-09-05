package _20210905_SpiralMatrixII;

/**
 * @author koalayt 2021-09-05
 */
public class Solution {

    enum Direction {
        RIGHT, DOWN, LEFT, UP;
    }

    static class SpiralWalker {
        Direction dir = Direction.RIGHT;
        int row = 0;
        int col = 0;

        void turn() {
            switch (dir) {
                case RIGHT:
                    dir = Direction.DOWN;
                    break;
                case DOWN:
                    dir = Direction.LEFT;
                    break;
                case LEFT:
                    dir = Direction.UP;
                    break;
                case UP:
                    dir = Direction.RIGHT;
                    break;
            }
        }

        void next() {
            switch (dir) {
                case RIGHT:
                    col += 1;
                    break;
                case DOWN:
                    row += 1;
                    break;
                case LEFT:
                    col -= 1;
                    break;
                case UP:
                    row -= 1;
                    break;
            }
        }

        void back() {
            switch (dir) {
                case RIGHT:
                    col -= 1;
                    break;
                case DOWN:
                    row -= 1;
                    break;
                case LEFT:
                    col += 1;
                    break;
                case UP:
                    row += 1;
                    break;
            }
        }

        int valueOf(int[][] matrix) {
            return matrix[row][col];
        }

        boolean outbound(int size) {
            return col >= size || row >= size || col < 0 || row < 0;
        }
    }

    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[][]{};
        }

        int[][] result = init(n);
        SpiralWalker walker = new SpiralWalker();

        for (int i = 0; i < n * n; i++) {
            result[walker.row][walker.col] = i + 1;
            walker.next();
            if (walker.outbound(n) || walker.valueOf(result) != 0) {
                walker.back();
                walker.turn();
                walker.next();
            }
        }

        return result;
    }

    private int[][] init(int n) {
        int[][] result = new int[n][];
        for (int i = 0; i < n; i++) {
            result[i] = new int[n];
        }
        return result;
    }

}

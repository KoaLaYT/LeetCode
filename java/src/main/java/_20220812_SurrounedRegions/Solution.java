package _20220812_SurrounedRegions;

public class Solution {

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        char[][] virtualBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                virtualBoard[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (virtualBoard[i][j] == 'X') continue;
                boolean isSurrounded = bfs(virtualBoard, i, j);
                if (isSurrounded) {
                    flip(board, i, j);
                }
            }
        }
    }

    private boolean bfs(char[][] virtualBoard, int i, int j) {
        int m = virtualBoard.length;
        int n = virtualBoard[0].length;

        if (virtualBoard[i][j] == 'X') {
            return true;
        }

        virtualBoard[i][j] = 'X';

        boolean result = true;

        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
            result = false;
        }

        if (i - 1 >= 0) result = bfs(virtualBoard, i - 1, j) && result;
        if (j + 1 < n) result = bfs(virtualBoard, i, j + 1) && result;
        if (i + 1 < m) result = bfs(virtualBoard, i + 1, j) && result;
        if (j - 1 >= 0) result = bfs(virtualBoard, i, j - 1) && result;

        return result;
    }

    private void flip(char[][] board, int i, int j) {
        if (board[i][j] == 'X') return;
        board[i][j] = 'X';
        flip(board, i - 1, j);
        flip(board, i, j + 1);
        flip(board, i + 1, j);
        flip(board, i, j - 1);
    }

}

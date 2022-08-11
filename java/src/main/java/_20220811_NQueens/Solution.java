package _20220811_NQueens;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = initBoard(n);
        List<List<String>> result = new ArrayList<>();
        solve(result, board, 0, n);
        return result;
    }

    private char[][] initBoard(int size) {
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }

    private void solve(List<List<String>> result, char[][] board, int row, int n) {
        if (row == n) {
            List<String> solution = buildSolution(board);
            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                solve(result, board, row + 1, n);
                board[row][col] = '.';
            }
        }
    }

    private List<String> buildSolution(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j]);
            }
            result.add(sb.toString());
        }
        return result;
    }

    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // col check
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            if (board[i][col] == 'Q') return false;
        }
        // left top
        int i = row - 1, j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        // right top
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }

        return true;
    }

}

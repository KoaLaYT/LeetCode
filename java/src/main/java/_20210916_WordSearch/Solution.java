package _20210916_WordSearch;

/**
 * @author koalayt 2021-09-16
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        if (board.length <= 0 || board[0].length <= 0) {
            return false;
        }
        if (word.length() <= 0) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean found = dfs(board, word, i, j, 0, 0);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    // dir
    // 0 - no prev dir
    // 1 - from left
    // 2 - from up
    // 3 - from right
    // 4 - from down
    private boolean dfs(char[][] board, String word, int i, int j, int p, int dir) {
        if (p == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length
                || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(p)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '\0';
        boolean found = false;
        if (dir == 0) {
            found = dfs(board, word, i, j - 1, p + 1, 1)
                    || dfs(board, word, i - 1, j, p + 1, 2)
                    || dfs(board, word, i, j + 1, p + 1, 3)
                    || dfs(board, word, i + 1, j, p + 1, 4);
        }
        if (dir == 1) {
            found = dfs(board, word, i, j - 1, p + 1, 1)
                    || dfs(board, word, i - 1, j, p + 1, 2)
                    || dfs(board, word, i + 1, j, p + 1, 4);
        }
        if (dir == 2) {
            found = dfs(board, word, i, j - 1, p + 1, 1)
                    || dfs(board, word, i - 1, j, p + 1, 2)
                    || dfs(board, word, i, j + 1, p + 1, 3);
        }
        if (dir == 3) {
            found = dfs(board, word, i - 1, j, p + 1, 2)
                    || dfs(board, word, i, j + 1, p + 1, 3)
                    || dfs(board, word, i + 1, j, p + 1, 4);
        }
        if (dir == 4) {
            found = dfs(board, word, i, j - 1, p + 1, 1)
                    || dfs(board, word, i, j + 1, p + 1, 3)
                    || dfs(board, word, i + 1, j, p + 1, 4);
        }
        board[i][j] = temp;
        return found;
    }

}

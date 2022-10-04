package _20221004_BattleshipsInABoard;

public class Solution {

    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                if (board[i][j] == '.') continue;
                count += 1;
                mark(board, visited, i, j);
            }
        }

        return count;
    }

    private void mark(char[][] board, boolean[][] visited, int x, int y) {
        for (int j = y; j < board[0].length; j++) {
            visited[x][j] = true;
            if (board[x][j] == '.') break;
        }

        for (int i = x; i < board.length; i++) {
            visited[i][y] = true;
            if (board[i][y] == '.') break;
        }
    }

}

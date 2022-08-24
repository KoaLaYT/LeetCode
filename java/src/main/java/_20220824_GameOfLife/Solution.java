package _20220824_GameOfLife;

public class Solution {

  private static final int[][] DIRS = new int[][]{
      {-1, -1}, {-1, 0}, {-1, 1},
      {0, -1},/*    */ {0, 1},
      {1, -1}, {1, 0}, {1, 1},
  };

  public void gameOfLife(int[][] board) {
    // rules
    // 1->1  1
    // 1->0 -1
    // 0->1  2
    // 0->0  0
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        int neighbors = checkLiveNeighbors(board, i, j);
        if (board[i][j] == 1) {
          if (neighbors < 2 || neighbors > 3) {
            board[i][j] = -1;
          }
        } else {
          if (neighbors == 3) {
            board[i][j] = 2;
          }
        }
      }
    }

    // rewrite to 0s and 1s
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 2) {
          board[i][j] = 1;
        }
        if (board[i][j] == -1) {
          board[i][j] = 0;
        }
      }
    }
  }

  private int checkLiveNeighbors(int[][] board, int i, int j) {
    int live = 0;
    for (int[] dir : DIRS) {
      int x = i + dir[0];
      int y = j + dir[1];
      if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
        continue;
      }
      if (Math.abs(board[x][y]) == 1) {
        live += 1;
      }
    }
    return live;
  }

}

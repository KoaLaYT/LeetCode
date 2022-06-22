package _20220622_MaxAreaOfIsland;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                max = Math.max(max, bfs(grid, i, j));
            }
        }

        return max;
    }

    private int bfs(int[][] grid, int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));

        int area = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Point p = queue.poll();
                if (p.isInBound(grid) && p.isIsland(grid)) {
                    area += 1;
                    p.markAsReached(grid);
                    queue.add(p.left());
                    queue.add(p.up());
                    queue.add(p.right());
                    queue.add(p.down());
                }
            }
        }

        return area;
    }

    private static class Point {
        int i;
        int j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        boolean isInBound(int[][] grid) {
            return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
        }

        boolean isIsland(int[][] grid) {
            return grid[i][j] == 1;
        }

        void markAsReached(int[][] grid) {
            grid[i][j] = 0;
        }

        Point left() {
            return new Point(i, j - 1);
        }

        Point up() {
            return new Point(i - 1, j);
        }

        Point right() {
            return new Point(i, j + 1);
        }

        Point down() {
            return new Point(i + 1, j);
        }
    }

}

package _20220731_MinimalDistance;

import java.util.*;

public class Solution {

    private static final int[][] DIR = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public int minimal_distance(int[][] grid, int row, int col) {
        Set<Point> visited = new HashSet<>();
        Queue<Point> points = new ArrayDeque<>();
        points.add(new Point(row, col));

        while (!points.isEmpty()) {
            Point point = points.poll();
            if (grid[point.x][point.y] == 1) {
                return point.distance(row, col);
            }
            visited.add(point);
            for (int[] dir : DIR) {
                Point next = new Point(point.x + dir[0], point.y + dir[1]);
                if (!visited.contains(next)
                        && next.isInBound(grid.length, grid[0].length)) {
                    points.add(next);
                }
            }
        }

        return -1;
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int distance(int row, int col) {
            return Math.abs(x - row) + Math.abs(y - col);
        }

        boolean isInBound(int row, int col) {
            return x >= 0 && x < row && y >= 0 && y < col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}

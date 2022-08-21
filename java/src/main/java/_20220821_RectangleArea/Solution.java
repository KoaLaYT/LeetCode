package _20220821_RectangleArea;

public class Solution {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        Rect r1 = new Rect(ax1, ay1, ax2, ay2);
        Rect r2 = new Rect(bx1, by1, bx2, by2);

        if (r1.isContain(r2)) {
            return r2.area();
        }

        if (r2.isContain(r1)) {
            return r1.area();
        }

        if (r1.isNonCross(r2)) {
            return r1.area() + r2.area();
        }

        return r1.area() + r2.area() - r1.crossArea(r2);
    }

    private static class Rect {
        Point leftBottom;
        Point rightTop;

        Rect(int ax1, int ay1, int ax2, int ay2) {
            this.leftBottom = new Point(ax1, ay1);
            this.rightTop = new Point(ax2, ay2);
        }

        int area() {
            return (rightTop.x - leftBottom.x) * (rightTop.y - leftBottom.y);
        }

        int crossArea(Rect other) {
            int vertical = vertical().crossLength(other.vertical());
            int horizontal = horizontal().crossLength(other.horizontal());
            return vertical * horizontal;
        }

        boolean isContain(Rect other) {
            return leftBottom.in(other) && rightTop.in(other);
        }

        boolean isNonCross(Rect other) {
            return rightTop.x <= other.leftBottom.x  // left
                    || leftBottom.x >= other.rightTop.x // right
                    || rightTop.y <= other.leftBottom.y // bottom
                    || leftBottom.y >= other.rightTop.y; // top
        }

        Line vertical() {
            return new Line(leftBottom, new Point(leftBottom.x, rightTop.y));
        }

        Line horizontal() {
            return new Line(leftBottom, new Point(rightTop.x, leftBottom.y));
        }

    }

    private static class Line {
        Point p1; // bottom / left
        Point p2; // top / right

        Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        boolean isVertical() {
            return p1.x == p2.x;
        }

        boolean isHorizontal() {
            return p1.y == p2.y;
        }

        // make sure parallelize with other
        int crossLength(Line other) {
            if (isVertical()) {
                int bottom = Math.max(p1.y, other.p1.y);
                int top = Math.min(p2.y, other.p2.y);
                return top - bottom;
            } else {
                int left = Math.max(p1.x, other.p1.x);
                int right = Math.min(p2.x, other.p2.x);
                return right - left;
            }
        }
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean in(Rect rect) {
            return x >= rect.leftBottom.x && x <= rect.rightTop.x
                    && y >= rect.leftBottom.y && y <= rect.rightTop.y;
        }
    }

}

package _20220323_PaintHouse;

public class Solution {

    public int minCost(int[][] costs) {
        int r = 0, g = 0, b = 0;

        for (int[] cost : costs) {
            int nr = cost[0] + Math.min(g, b);
            int ng = cost[1] + Math.min(r, b);
            int nb = cost[2] + Math.min(r, g);

            r = nr;
            g = ng;
            b = nb;
        }

        return Math.min(Math.min(r, g), b);
    }

}

package _20220725_FindMinArrowShots;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }

        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));

        int shots = 1;
        int right = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (right < points[i][0]) {
                shots += 1;
                right = points[i][1];
            }
        }

        return shots;
    }

}

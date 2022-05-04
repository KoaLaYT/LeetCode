package _20220504_MinimumNumberOfArrowsToBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
        int shots = 1;
        long right = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (right < points[i][0]) {
                shots++;
                right = points[i][1];
            }
        }

        return shots;
    }

}

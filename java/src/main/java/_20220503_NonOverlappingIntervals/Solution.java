package _20220503_NonOverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(it -> it[1]));
        int count = 0;
        int right = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (interval[0] < right) {
                count++;
            } else {
                right = interval[1];
            }
        }

        return count;
    }

}

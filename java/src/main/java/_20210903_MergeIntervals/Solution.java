package _20210903_MergeIntervals;

import java.util.*;

/**
 * @author koalayt 2021-09-03
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        if (Objects.isNull(intervals) || intervals.length == 0) {
            return new int[][]{};
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            if (end >= interval[0]) {
                end = Math.max(end, interval[1]);
            } else {
                merged.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        merged.add(new int[]{start, end});
        return merged.toArray(new int[merged.size()][]);
    }

}

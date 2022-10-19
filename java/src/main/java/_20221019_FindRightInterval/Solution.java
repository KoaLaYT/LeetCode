package _20221019_FindRightInterval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        Map<Integer, Integer> pos = buildPosMap(intervals);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            int index = binarySearch(intervals, i, len - 1, e);
            if (index == -1) {
                result[pos.get(s)] = -1;
            } else {
                result[pos.get(s)] = pos.get(intervals[index][0]);
            }
        }

        return result;
    }

    private int binarySearch(int[][] intervals, int lo, int hi, int target) {
        int limit = lo;

        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (target > intervals[mi][0]) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }

        while (lo >= intervals.length || (lo < limit && intervals[lo][0] > target)) {
            lo -= 1;
        }

        return (lo < limit || intervals[lo][0] < target) ? -1 : lo;
    }

    // preconditions:
    // every interval [a, b] has an unique `a`
    private Map<Integer, Integer> buildPosMap(int[][] intervals) {
        Map<Integer, Integer> pos = new HashMap<>();

        for (int i = 0; i < intervals.length; i++) {
            pos.put(intervals[i][0], i);
        }

        return pos;
    }

}

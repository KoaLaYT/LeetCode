package _20220409_ShortestDistanceToTargetColor;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < colors.length; i++) {
            lists.get(colors[i] - 1).add(i);
        }

        List<Integer> result = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            List<Integer> list = lists.get(query[1] - 1);
            int pos = binarySearch(list, query[0]);

            int res = -1;
            if (pos == 0) {
                res = list.get(0) - query[0];
            } else if (pos == list.size()) {
                res = query[0] - list.get(pos - 1);
            } else if (pos != -1) {
                res = Math.min(Math.abs(list.get(pos) - query[0]), Math.abs(list.get(pos - 1) - query[0]));
            }

            result.add(res);
        }
        return result;
    }

    private int binarySearch(List<Integer> list, int target) {
        if (list.isEmpty()) {
            return -1;
        }

        int lo = 0;
        int hi = list.size() - 1;

        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            int val = list.get(mi);
            if (val == target) {
                return mi;
            } else if (val < target) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }

        return lo;
    }

}

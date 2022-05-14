package _20220514_NumberOfCornerRectangles;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int countCornerRectangles(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();

        int total = 0;
        for (int[] row : grid) {
            for (int c1 = 0; c1 < row.length; c1++) {
                if (row[c1] != 1) continue;
                for (int c2 = c1 + 1; c2 < row.length; c2++) {
                    if (row[c2] != 1) continue;

                    int key = c1 * 200 + c2;
                    int count = map.getOrDefault(key, 0);
                    total += count;
                    map.put(key, count + 1);
                }
            }
        }

        return total;
    }

}

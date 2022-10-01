package _20221001_QueueReconstructionByHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            int cmp = p2[0] - p1[0];
            if (cmp == 0) {
                return p1[1] - p2[1];
            }
            return cmp;
        });

        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }

        return queue.toArray(new int[queue.size()][]);
    }

}

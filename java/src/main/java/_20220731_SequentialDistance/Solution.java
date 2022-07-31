package _20220731_SequentialDistance;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public boolean sequential_distance(int[] x, int[] y) {
        List<Integer> xx = Arrays.stream(x).boxed().collect(Collectors.toList());
        List<Integer> yy = Arrays.stream(y).boxed().collect(Collectors.toList());

        Set<List<Integer>> origins = swap3Times(xx);
        Set<List<Integer>> targets = swap3Times(yy);

        for (List<Integer> origin : origins) {
            if (targets.contains(origin)) {
                return true;
            }
        }

        return false;
    }

    private Set<List<Integer>> swap3Times(List<Integer> y) {
        Set<List<Integer>> set = new HashSet<>();
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.add(y);

        for (int step = 1; step <= 3; step++) {
            int size = queue.size();
            for (int len = 0; len < size; len++) {
                List<Integer> head = queue.poll();
                for (int i = 0; i < head.size(); i++) {
                    for (int j = i + 1; j < head.size(); j++) {
                        List<Integer> copy = new ArrayList<>(head);
                        swap(copy, i, j);
                        queue.add(copy);
                        if (step == 3) set.add(copy);
                    }
                }
            }
        }

        return set;
    }

    private void swap(List<Integer> arr, int i, int j) {
        int tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }

}

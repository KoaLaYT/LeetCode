package _20220727_FindDiagonalOrder;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int len = 0;
        for (List<Integer> num : nums) {
            len += num.size();
        }

        Pair[] pairs = new Pair[len];
        int k = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                pairs[k++] = new Pair(i, j);
            }
        }
        Arrays.sort(pairs);

        int[] result = new int[len];
        k = 0;
        for (Pair pair : pairs) {
            result[k++] = nums.get(pair.i).get(pair.j);
        }

        return result;
    }

    private static class Pair implements Comparable<Pair> {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        private int sum() {
            return i + j;
        }

        @Override
        public int compareTo(Pair o) {
            int thisSum = sum();
            int thatSum = o.sum();
            if (thatSum == thisSum) {
                return -1 * Integer.compare(i, o.i);
            }
            return Integer.compare(thisSum, thatSum);
        }
    }

}

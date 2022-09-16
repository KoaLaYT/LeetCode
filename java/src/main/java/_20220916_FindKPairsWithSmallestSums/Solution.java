package _20220916_FindKPairsWithSmallestSums;

import java.util.*;

public class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int[] c1 = new int[nums1.length + 1];
        int[] c2 = new int[nums2.length + 1];
        Arrays.fill(c1, 1);
        Arrays.fill(c2, 1);
        c1[1] = 2;
        c2[1] = 2;

        List<Pair> candidates = new ArrayList<>();
        if (nums1.length >= 2) {
            candidates.add(new Pair(2, 1));
        }
        if (nums2.length >= 2) {
            candidates.add(new Pair(1, 2));
        }

        List<List<Integer>> result = new ArrayList<>(k);
        result.add(Arrays.asList(nums1[0], nums2[0]));

        for (int i = 1; i < k; i++) {
            int minJ = -1;
            int minSum = Integer.MAX_VALUE;
            for (int j = 0; j < candidates.size(); j++) {
                Pair pair = candidates.get(j);
                int sum = nums1[pair.i - 1] + nums2[pair.j - 1];
                if (sum < minSum) {
                    minJ = j;
                    minSum = sum;
                }
            }
            if (minJ == -1) break;
            Pair pair = candidates.get(minJ);
            candidates.remove(minJ);
            c1[pair.i] = pair.j + 1;
            c2[pair.j] = pair.i + 1;

            if (pair.i + 1 < c1.length && c1[pair.i + 1] >= pair.j && c2[pair.j] >= pair.i + 1) {
                candidates.add(new Pair(pair.i + 1, pair.j));
            }
            if (pair.j + 1 < c2.length && c1[pair.i] >= pair.j + 1 && c2[pair.j + 1] >= pair.i) {
                candidates.add(new Pair(pair.i, pair.j + 1));
            }
            result.add(Arrays.asList(nums1[pair.i - 1], nums2[pair.j - 1]));

        }

        return result;
    }

    private static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}

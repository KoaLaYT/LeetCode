package _20220807_MinimumCost;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int minimumCost(int n, int[][] connections) {
        UnionSet set = new UnionSet(n);
        Arrays.sort(connections, Comparator.comparingInt(c -> c[2]));

        int cost = 0;
        for (int[] connection : connections) {
            int v1 = connection[0];
            int v2 = connection[1];
            if (set.isConnected(v1, v2)) continue;
            cost += connection[2];
            set.union(v1, v2);
        }

        return set.isAllConnected() ? cost : -1;
    }

    private static class UnionSet {
        private final int[] roots;

        UnionSet(int n) {
            roots = new int[n + 1];
            Arrays.fill(roots, -1);
        }

        boolean isAllConnected() {
            for (int i = 2; i < roots.length; i++) {
                if (!isConnected(i, i - 1)) return false;
            }
            return true;
        }

        boolean isConnected(int v1, int v2) {
            return find(v1) == find(v2);
        }

        void union(int v1, int v2) {
            int root1 = find(v1);
            int root2 = find(v2);
            if (root1 == root2) {
                return;
            }
            roots[root1] = root2;
        }

        private int find(int v) {
            if (roots[v] == -1) {
                return v;
            }
            int root = find(roots[v]);
            roots[v] = root;
            return root;
        }
    }

}

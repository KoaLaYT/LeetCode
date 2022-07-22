package _20220722_MinimalOperators;

public class Solution {

    public int minimalOperators(int n, int[][] trust) {
        int[] ins = new int[n];
        int[] outs = new int[n];

        for (int[] pair : trust) {
            ins[pair[1]] += 1;
            outs[pair[0]] += 1;
        }

        int ops = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            ops = Math.min(ops, n - 1 - ins[i] + outs[i]);
        }

        return ops;
    }

}

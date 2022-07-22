package _20220722_FindJudge;

public class Solution {

    public int findJudge(int n, int[][] trust) {
        int[] ins = new int[n + 1];
        int[] outs = new int[n + 1];

        for (int[] pair : trust) {
            ins[pair[0]] += 1;
            outs[pair[1]] += 1;
        }

        for (int i = 1; i <= n; i++) {
            if (ins[i] == 0 && outs[i] == n-1) {
                return i;
            }
        }

        return -1;
    }

}

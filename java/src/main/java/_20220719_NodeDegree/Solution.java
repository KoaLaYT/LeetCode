package _20220719_NodeDegree;

public class Solution {

    public int[] nodeDegree(int n, int[][] e) {
        int[] result = new int[n];
        for (int[] edge : e) {
            result[edge[0]] += 1;
            result[edge[1]] += 1;
        }
        return result;
    }

}

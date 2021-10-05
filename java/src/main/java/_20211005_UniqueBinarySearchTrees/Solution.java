package _20211005_UniqueBinarySearchTrees;

/**
 * @author koalayt 2021-10-05
 */
public class Solution {

    public int numTrees(int n) {
        int[] records = new int[20];
        records[0] = 1;
        records[1] = 1;
        return numTrees(n, records);
    }

    private int numTrees(int n, int[] records) {
        if (records[n] == 0) {
            int sum = 0;
            for (int left = 0; left < n; left++) {
                int right = n - left - 1;
                sum += numTrees(left, records) * numTrees(right, records);
            }
            records[n] = sum;
        }
        return records[n];
    }

}

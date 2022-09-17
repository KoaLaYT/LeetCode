package _20220917_KthSmallestElementInASortedMatrix;

import java.util.PriorityQueue;

public class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        PriorityQueue<Candidate> queue = new PriorityQueue<>();
        boolean[][] added = new boolean[len][len];

        queue.add(new Candidate(matrix[0][0], 0, 0));
        added[0][0] = true;

        int kth = 0;
        for (int i = 0; i < k; i++) {
            Candidate candidate = queue.poll();
            int value = candidate.value;
            int x = candidate.x;
            int y = candidate.y;

            kth = value;

            if (x + 1 < len && !added[x + 1][y]) {
                queue.add(new Candidate(matrix[x + 1][y], x + 1, y));
                added[x + 1][y] = true;
            }
            if (y + 1 < len && !added[x][y + 1]) {
                queue.add(new Candidate(matrix[x][y + 1], x, y + 1));
                added[x][y + 1] = true;
            }
        }

        return kth;
    }

    private static class Candidate implements Comparable<Candidate> {
        int value;
        int x;
        int y;

        Candidate(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Candidate o) {
            return Integer.compare(value, o.value);
        }
    }

}

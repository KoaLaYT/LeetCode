package _20220704_MergeKHeaps;

import java.util.PriorityQueue;

public class Solution {

    public int[] mergeKHeaps(int[][] heaps) {
        if (heaps == null || heaps.length <= 0) {
            return new int[]{};
        }

        int[] size = new int[heaps.length];
        int total = 0;
        PriorityQueue<Data> pq = new PriorityQueue<>();
        for (int i = 0; i < heaps.length; i++) {
            if (heaps[i] == null) {
                continue;
            }
            int len = heaps[i].length;
            size[i] = len;
            total += len;
            if (len > 0) {
                pq.add(new Data(heaps[i][0], i));
            }
        }

        int[] result = new int[total];
        int i = 0;
        while (!pq.isEmpty()) {
            Data data = pq.poll();
            result[i++] = data.val;
            int index = data.index;
            size[index] -= 1;
            heapify(heaps[index], size[index]);
            if (size[index] > 0) {
                pq.add(new Data(heaps[index][0], index));
            }
        }

        return result;
    }

    private void heapify(int[] heap, int size) {
        swap(heap, 0, size);
        sink(heap, 0, size);
    }

    private void sink(int[] heap, int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        int min = index;

        if (left < size && heap[left] < heap[min]) {
            min = left;
        }

        if (right < size && heap[right] < heap[min]) {
            min = right;
        }

        if (min != index) {
            swap(heap, min, index);
            sink(heap, min, size);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static class Data implements Comparable<Data> {
        int val;
        int index;

        Data(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Data o) {
            return val - o.val;
        }
    }

}

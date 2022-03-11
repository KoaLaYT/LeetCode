package _20220311_KClosestPointsToOrigin;

public class Solution {

    public int[][] kClosest(int[][] points, int k) {
        MinPQ pq = new MinPQ(k);
        for (int i = 0; i < points.length; i++) {
            int distance = calDistance(points[i]);
            pq.add(new DistanceWithIndex(distance, i));
        }

        int[][] result = new int[k][];
        DistanceWithIndex[] items = pq.getArr();
        for (int i = 0; i < k; i++) {
            result[i] = points[items[i].index];
        }
        return result;
    }

    private int calDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private static class DistanceWithIndex {
        private int distance;
        private int index;

        DistanceWithIndex(int distance, int index) {
            this.distance = distance;
            this.index = index;
        }

        @Override
        public String toString() {
            return String.format("D[%02d,%02d]", distance, index);
        }
    }

    private static class MinPQ {
        private DistanceWithIndex[] arr;
        private int size;
        private int count;

        MinPQ(int size) {
            this.arr = new DistanceWithIndex[size];
            this.size = size;
            this.count = 0;
        }

        void add(DistanceWithIndex item) {
            if (this.count < this.size) {
                arr[count++] = item;
                bubble(count - 1);
            } else if (item.distance < arr[0].distance) {
                arr[0] = item;
                sink(0);
            }
        }

        DistanceWithIndex[] getArr() {
            return arr;
        }

        private void sink(int index) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;

            if (index >= this.size) {
                return;
            }

            int larger = index;
            if (left < this.size && arr[left].distance > arr[larger].distance) {
                larger = left;
            }
            if (right < this.size && arr[right].distance > arr[larger].distance) {
                larger = right;
            }

            if (larger != index) {
                swap(index, larger);
                sink(larger);
            }
        }

        private void bubble(int index) {
            if (index == 0) {
                return;
            }

            int top = (index + 1) / 2 - 1;
            int left = 2 * top + 1;
            int right = 2 * top + 2;

            int larger = top;
            if (left < this.count && arr[left].distance > arr[larger].distance) {
                larger = left;
            }
            if (right < this.count && arr[right].distance > arr[larger].distance) {
                larger = right;
            }

            if (larger != top) {
                swap(top, larger);
                bubble(top);
            }
        }

        private void swap(int i, int j) {
            DistanceWithIndex tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}

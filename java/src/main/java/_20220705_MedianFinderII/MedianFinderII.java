package _20220705_MedianFinderII;

public class MedianFinderII {

    private final int[] memo;
    private int size;

    public MedianFinderII() {
        this.memo = new int[101];
        this.size = 0;
    }

    public void addNum(int num) {
        memo[num] += 1;
        size += 1;
    }

    public double findMedian() {
        if (size == 0) {
            return -1.0;
        }

        int i = 0;
        int j = 1;

        if (size % 2 == 0) {
            while (i < size / 2) {
                i += memo[j++];
            }
            if (i > size / 2) {
                return j - 1;
            }
            int k = j;
            while (memo[k] == 0) {
                k++;
            }

            return (j - 1 + k) / 2.0;
        } else {
            while (i < size / 2 + 1) {
                i += memo[j++];
            }
            return j - 1;
        }
    }

}

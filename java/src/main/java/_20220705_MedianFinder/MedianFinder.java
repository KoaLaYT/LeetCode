package _20220705_MedianFinder;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    private final PriorityQueue<Integer> left;
    private final PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Comparator.reverseOrder());
        right = new PriorityQueue<>(Comparator.naturalOrder());
    }

    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());

        if (right.size() - left.size() > 1) {
            left.add(right.poll());
        }
    }

    public double findMedian() {
        if (right.size() > left.size()) {
            return right.peek();
        } else {
            return (left.peek() + right.peek()) / 2.0;
        }
    }

}

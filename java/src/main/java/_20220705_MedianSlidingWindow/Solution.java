package _20220705_MedianSlidingWindow;

import java.util.Objects;
import java.util.TreeSet;

public class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || nums.length < k) {
            return new double[]{};
        }

        double[] result = new double[nums.length - k + 1];
        MedianSlidingWindow msw = new MedianSlidingWindow();

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                msw.add(nums[i], i);
            } else {
                result[i - k] = msw.getMedian();
                msw.remove(nums[i - k], i - k);
                msw.add(nums[i], i);
            }
        }
        result[result.length - 1] = msw.getMedian();

        return result;
    }

    private static class WrappedInt implements Comparable<WrappedInt> {
        int val;
        int index;

        WrappedInt(int val, int index) {
            this.val = val;
            this.index = index;
        }


        @Override
        public int compareTo(WrappedInt o) {
            if (val == o.val) {
                return Integer.compare(index, o.index);
            }

            return Integer.compare(val, o.val);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WrappedInt that = (WrappedInt) o;
            return val == that.val && index == that.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, index);
        }
    }

    private static class MedianSlidingWindow {
        private final TreeSet<WrappedInt> left = new TreeSet<>();
        private final TreeSet<WrappedInt> right = new TreeSet<>();

        void add(int v, int i) {
            left.add(new WrappedInt(v, i));
            right.add(left.pollLast());
            keepBalance();
        }

        double getMedian() {
            if (left.size() == right.size()) {
                return ((long) left.last().val + right.first().val) / 2.0;
            }
            return right.first().val;
        }

        void remove(int v, int i) {
            WrappedInt wi = new WrappedInt(v, i);
            if (left.remove(wi)) {
                keepBalance();
                return;
            }

            right.remove(wi);
            if (right.size() < left.size()) {
                right.add(left.pollLast());
            }
        }

        void keepBalance() {
            if (right.size() - left.size() > 1) {
                left.add(right.pollFirst());
            }
        }

    }

}

package _20220828_RangeSumQueryMutable;

public class NumArray {

    private final int[] segmentTree;
    private final int len;

    public NumArray(int[] nums) {
        len = nums.length;
        segmentTree = buildTree(nums);
    }

    public void update(int index, int val) {
        update(0, index, 0, len - 1, val);
    }

    public int sumRange(int left, int right) {
        return sumRange(0, left, right, 0, len - 1);
    }

    private int[] buildTree(int[] nums) {
        int[] segments = new int[len * 4];
        buildTree(nums, segments, 0, 0, len - 1);
        return segments;
    }

    private void buildTree(int[] nums, int[] segments, int node, int left, int right) {
        if (left == right) {
            segments[node] = nums[left];
            return;
        }

        int mid = left + (right - left) / 2;
        buildTree(nums, segments, 2 * node + 1, left, mid);
        buildTree(nums, segments, 2 * node + 2, mid + 1, right);
        segments[node] = segments[2 * node + 1] + segments[2 * node + 2];
    }

    private void update(int node, int index, int left, int right, int val) {
        if (left == right) {
            segmentTree[node] = val;
            return;
        }

        int mid = left + (right - left) / 2;
        if (index <= mid) {
            update(2 * node + 1, index, left, mid, val);
        } else {
            update(2 * node + 2, index, mid + 1, right, val);
        }

        segmentTree[node] = segmentTree[2 * node + 1] + segmentTree[2 * node + 2];
    }

    private int sumRange(int node, int left, int right, int start, int end) {
        if (left == start && right == end) {
            return segmentTree[node];
        }

        int mid = start + (end - start) / 2;
        if (right <= mid) {
            return sumRange(2 * node + 1, left, right, start, mid);
        } else if (left > mid) {
            return sumRange(2 * node + 2, left, right, mid + 1, end);
        } else {
            return sumRange(2 * node + 1, left, mid, start, mid)
                    + sumRange(2 * node + 2, mid + 1, right, mid + 1, end);
        }
    }
}

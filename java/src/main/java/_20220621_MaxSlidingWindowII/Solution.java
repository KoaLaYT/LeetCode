package _20220621_MaxSlidingWindowII;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public int[] maxSlidingWindowII(int[] nums, int[] a, int[] b) {
        Deque<Integer> queue = new LinkedList<>();

        int lo = 0;
        int hi = 0;
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[i]; j++) {
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[hi]) {
                    queue.removeLast();
                }
                queue.addLast(hi);
                hi += 1;
            }
            for (int j = 0; j < a[i]; j++) {
                lo += 1;
                if (!queue.isEmpty() && lo > queue.peekFirst()) {
                    queue.removeFirst();
                }
            }
            result[i] = queue.isEmpty() ? -1 : nums[queue.peekFirst()];
        }

        return result;
    }

}

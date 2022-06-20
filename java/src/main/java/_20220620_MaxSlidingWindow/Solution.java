package _20220620_MaxSlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Info> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            while (!queue.isEmpty()) {
                if (queue.peekLast().num <= num) queue.pollLast();
                else break;
            }
            queue.addLast(new Info(num, i + k));

            if (queue.peekFirst().pos == i) queue.pollFirst();

            if (i - k + 1 >= 0) {
                result[i - k + 1] = queue.peekFirst().num;
            }
        }

        return result;
    }

    private static class Info {
        int num;
        int pos;

        Info(int num, int pos) {
            this.num = num;
            this.pos = pos;
        }
    }

}

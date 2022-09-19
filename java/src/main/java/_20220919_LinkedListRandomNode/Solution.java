package _20220919_LinkedListRandomNode;

import common.ListNode;

import java.util.concurrent.ThreadLocalRandom;

public class Solution {

    private final int[] list;

    public Solution(ListNode head) {
        int len = size(head);
        this.list = new int[len];
        for (int i = 0; i < len; i++) {
            list[i] = head.val;
            head = head.next;
        }
    }

    public int getRandom() {
        int randomIndex = ThreadLocalRandom.current().nextInt(list.length);
        return list[randomIndex];
    }

    private int size(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len += 1;
        }
        return len;
    }

}

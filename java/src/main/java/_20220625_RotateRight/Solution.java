package _20220625_RotateRight;

import common.ListNode;

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null) {
            return head;
        }

        int len = getLen(head);
        k = k % len;

        if (k == 0) {
            return head;
        }

        ListNode fst = head;

        ListNode snd = head;
        while (k > 0) {
            snd = snd.next;
            k--;
        }

        while (snd.next != null) {
            fst = fst.next;
            snd = snd.next;
        }

        ListNode newHead = fst.next;
        fst.next     = null;
        snd.next = head;

        return newHead;
    }

    private int getLen(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }

}

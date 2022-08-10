package _20220810_ReverseKGroup;

import common.ListNode;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }

        ListNode newHead = null;
        ListNode preLast = null;
        ListNode cur = head;
        while (true) {
            int n = 1;
            ListNode first = cur;
            while (n < k && cur != null) {
                cur = cur.next;
                n++;
            }
            if (cur == null) break;

            ListNode last = cur;
            cur = last.next;

            reverseList(first, last);

            if (newHead == null) newHead = last;
            if (preLast != null) preLast.next = last;

            first.next = cur;
            preLast = first;
        }

        return newHead;
    }

    private void reverseList(ListNode head, ListNode tail) {
        ListNode pre = head;
        ListNode cur = head.next;
        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

}

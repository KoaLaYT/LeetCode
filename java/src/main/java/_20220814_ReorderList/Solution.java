package _20220814_ReorderList;

import common.ListNode;

public class Solution {

    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }

        ListNode mid = findMiddle(head);
        ListNode right = mid.next;
        mid.next = null;
        right = reverse(right);
        merge(head, right, mid);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;

            if (fast.next == null) {
                break;
            }

            fast = fast.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = node;
        ListNode cur = node.next;
        pre.next = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    private void merge(ListNode left, ListNode right, ListNode mid) {
        while (right != null) {
            ListNode leftNext = left.next;
            ListNode rightNext = right.next;
            left.next = right;
            right.next = leftNext;
            left = leftNext;
            right = rightNext;
        }
    }

}

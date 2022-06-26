package _20220626_DeleteDuplicatesII;

import common.ListNode;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                pre = cur;
                cur = cur.next;
            } else {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                if (pre != null) {
                    pre.next = cur.next;
                } else {
                    head = cur.next;
                }
                cur = cur.next;
            }
        }

        return head;
    }

}

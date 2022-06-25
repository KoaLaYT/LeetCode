package _20220624_OddEvenList;

import common.ListNode;

public class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode evenHead = head.next;

        boolean  isOdd   = true;
        ListNode curOdd  = head;
        ListNode curEven = evenHead;
        ListNode cur     = evenHead.next;

        while (cur != null) {
            if (isOdd) {
                curOdd.next = cur;
                curOdd      = cur;
            } else {
                curEven.next = cur;
                curEven      = cur;
            }
            cur   = cur.next;
            isOdd = !isOdd;
        }
        curOdd.next = evenHead;
        curEven.next = null;

        return head;
    }

}

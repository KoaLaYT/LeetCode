package _20210906_RotateList;

import java.util.Objects;

/**
 * @author koalayt 2021-09-06
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (Objects.isNull(head)) {
            return null;
        }

        k %= size(head);
        if (k == 0) {
            return head;
        }

        ListNode first = head;
        ListNode second = head;

        while (k > 0) {
            first = Objects.isNull(first.next) ? head : first.next;
            k--;
        }

        while (Objects.nonNull(first.next)) {
            first = first.next;
            second = second.next;
        }

        first.next = head;
        head = second.next;
        second.next = null;

        return head;
    }

    private int size(ListNode head) {
        int len = 0;
        while (Objects.nonNull(head)) {
            len++;
            head = head.next;
        }
        return len;
    }

}

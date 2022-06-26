package _20220626_RemoveNthFromEnd;

import common.ListNode;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        ListNode fst = head;
        ListNode snd = head;

        while (n > 0) {
            snd = snd.next;
            n--;
        }

        if (snd == null) {
            return head.next;
        }

        while (snd.next != null) {
            fst = fst.next;
            snd = snd.next;
        }

        fst.next = fst.next.next;

        return head;
    }

}

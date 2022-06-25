package _20220625_DeleteDuplicates;

import common.ListNode;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fst = head;
        ListNode snd = head.next;

        while (snd != null) {
            if (fst.val == snd.val) {
                fst.next = snd.next;
                snd = snd.next;
            } else {
                fst = snd;
                snd = snd.next;
            }
        }

        return head;
    }

}

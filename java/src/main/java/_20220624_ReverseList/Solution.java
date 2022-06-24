package _20220624_ReverseList;

public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode reversed = null;
        ListNode origin   = head;

        while (origin != null) {
            ListNode tmp = origin.next;
            origin.next = reversed;
            reversed    = origin;
            origin      = tmp;
        }

        return reversed;
    }

}
